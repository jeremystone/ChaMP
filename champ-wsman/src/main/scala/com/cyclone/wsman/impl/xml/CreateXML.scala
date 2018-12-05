package com.cyclone.wsman.impl.xml

import com.cyclone.command.SelectorClause
import com.cyclone.util.OperationDeadline
import com.cyclone.wsman.impl.Namespace
import com.cyclone.wsman.impl.model.ManagedInstance

import scala.xml.Elem

case class CreateXML(
  managedInstance: ManagedInstance,
  resourceURI: String,
  selectors: SelectorClause,
  deadline: OperationDeadline
) extends RequestXMLWithDeadline {

  import RequestXML._

  // @formatter:off
  override def xml(toAddress: String): Elem =
    <s:Envelope xmlns:s={ Namespace.SOAP } xmlns:a={ Namespace.ADDRESSING } xmlns:w={ Namespace.WSMAN }>
      <s:Header>
        <a:To>{ toAddress }</a:To>
        <w:ResourceURI s:mustUnderstand="true">{ resourceURI }</w:ResourceURI>
        <a:ReplyTo>
          <a:Address s:mustUnderstand="true">{ Namespace.REPLY_ANON }</a:Address>
        </a:ReplyTo>
        <a:Action s:mustUnderstand="true">http://schemas.xmlsoap.org/ws/2004/09/transfer/Create</a:Action>
        { maxEnvelopeSizeElt }
        <a:MessageID>{ uuid }</a:MessageID>
        <w:Locale xml:lang="en-US" s:mustUnderstand="false"/>
        { timeoutElt }
        { selectorSetElt(selectors) }
      </s:Header>
      <s:Body>
        { managedInstance.root }
      </s:Body>
    </s:Envelope>

}