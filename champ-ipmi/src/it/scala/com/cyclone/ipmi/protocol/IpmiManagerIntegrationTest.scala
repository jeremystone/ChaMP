package com.cyclone.ipmi.protocol

import akka.testkit.ImplicitSender
import com.cyclone.akka.ActorSystemShutdown
import com.cyclone.command.{OperationDeadline, TimeoutContext}
import com.cyclone.ipmi._
import com.cyclone.ipmi.command.chassis.GetChassisStatus
import com.cyclone.ipmi.command.ipmiMessagingSupport.GetSessionChallenge
import com.cyclone.ipmi.protocol.packet.IpmiCommandResult
import com.cyclone.ipmi.protocol.rakp.RmcpPlusAndRakpStatusCodeErrors
import org.scalatest.{Inside, Matchers, WordSpecLike}

import scala.concurrent.duration._

/**
  * Integration test for Ipmi
  */
class IpmiManagerIntegrationTest
    extends BaseIntegrationTest
    with WordSpecLike
    with Matchers
    with Inside
    with ImplicitSender
    with ActorSystemShutdown {

  class Fixture {
    val ipmiMgr = system.actorOf(IpmiManager.props())

    ipmiMgr ! IpmiManager.CreateSessionManagerFor(host, port)

    val IpmiManager.SessionManagerCreated(sessionMgr) = expectMsgType[IpmiManager.SessionManagerCreated]

    implicit val timeoutContext: TimeoutContext = TimeoutContext(OperationDeadline.fromNow(2.seconds))
  }

  // So we can ensure v15 and v20 give same command results
  var v2CommandResult: IpmiCommandResult = _

  "an ipmi manager" when {
    "using version 2.0" must {
      val versionRequirement = IpmiVersionRequirement.V20Only

      "create a session" in new Fixture {
        sessionMgr ! SessionManager.NegotiateSession(credentials, versionRequirement)

        expectMsg(SessionManager.SessionNegotiationSuccess)
      }

      "fail to create a session when use wrong user name" in new Fixture {
        sessionMgr ! SessionManager.NegotiateSession(IpmiCredentials("ss", "ADMIN"), versionRequirement)

        // This is what the tests IPMI implementation gives for ipmitool...
        expectMsg(SessionManager.SessionNegotiationError(RmcpPlusAndRakpStatusCodeErrors.IllegalParameter))
      }

      "fail to create a session when use wrong password" in new Fixture {
        sessionMgr ! SessionManager.NegotiateSession(IpmiCredentials("ADMIN", "wrong"), versionRequirement)

        expectMsg(SessionManager.SessionNegotiationError(RmcpPlusAndRakpStatusCodeErrors.InvalidIntegrityCheckValue))
      }

      "execute a command" in new Fixture {
        sessionMgr ! SessionManager.NegotiateSession(credentials, versionRequirement)
        expectMsg(SessionManager.SessionNegotiationSuccess)

        sessionMgr ! SessionManager.ExecuteCommand(GetChassisStatus.Command)
        inside(expectMsgType[SessionManager.CommandExecutionSuccess]) {
          case SessionManager.CommandExecutionSuccess(result) =>
            result shouldBe a[GetChassisStatus.CommandResult]
            v2CommandResult = result
        }
      }
    }

    "using version 1.5" must {
      val versionRequirement = IpmiVersionRequirement.V15Only

      "create a session" in new Fixture {
        sessionMgr ! SessionManager.NegotiateSession(credentials, versionRequirement)

        expectMsg(SessionManager.SessionNegotiationSuccess)
      }

      "fail to create a session when use wrong user name" in new Fixture {
        sessionMgr ! SessionManager.NegotiateSession(IpmiCredentials("ss", "ADMIN"), versionRequirement)

        expectMsg(SessionManager.SessionNegotiationError(GetSessionChallenge.InvalidUserName))
      }

      "fail to create a session when use wrong password" in new Fixture {
        sessionMgr ! SessionManager.NegotiateSession(IpmiCredentials("ADMIN", "wrong"), versionRequirement)

        // We get nothing back with ipmitool either...
        expectMsg(SessionManager.SessionNegotiationError(DeadlineReached))
      }

      "execute a command with same result" in new Fixture {
        sessionMgr ! SessionManager.NegotiateSession(credentials, versionRequirement)
        expectMsg(SessionManager.SessionNegotiationSuccess)

        sessionMgr ! SessionManager.ExecuteCommand(GetChassisStatus.Command)
        inside(expectMsgType[SessionManager.CommandExecutionSuccess]) {
          case SessionManager.CommandExecutionSuccess(result) => result shouldBe v2CommandResult
        }
      }
    }
  }
}
