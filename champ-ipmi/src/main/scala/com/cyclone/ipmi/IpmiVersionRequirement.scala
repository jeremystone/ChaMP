package com.cyclone.ipmi

/**
  * Indication of the Ipmi version that should be used for requests.
  */
sealed trait IpmiVersionRequirement

object IpmiVersionRequirement {

  case object V15Only extends IpmiVersionRequirement

  case object V20Only extends IpmiVersionRequirement

  case object V20IfSupported extends IpmiVersionRequirement

  private lazy val nameMap =
    Seq(V15Only, V20Only, V20IfSupported)
      .map(vr => vr.toString.toUpperCase -> vr)
      .toMap

  def all: Iterable[IpmiVersionRequirement] = nameMap.values

  def parse(name: String): Option[IpmiVersionRequirement] =
    nameMap.get(name.toUpperCase)
}
