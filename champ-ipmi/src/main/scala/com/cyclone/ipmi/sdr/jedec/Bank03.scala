package com.cyclone.ipmi.sdr.jedec

object Bank03 extends Manufacturer.Bank {

  protected lazy val names: Map[Byte, String] = Map(
    0x01.toByte -> "Camintonn Corporation",
    0x02.toByte -> "ISOA Incorporated",
    0x83.toByte -> "Agate Semiconductor",
    0x04.toByte -> "ADMtek Incorporated",
    0x85.toByte -> "HYPERTEC",
    0x86.toByte -> "Adhoc Technologies",
    0x07.toByte -> "MOSAID Technologies",
    0x08.toByte -> "Ardent Technologies",
    0x89.toByte -> "Switchcore",
    0x8A.toByte -> "Cisco Systems, Inc.",
    0x0B.toByte -> "Allayer Technologies",
    0x8C.toByte -> "WorkX AG (Wichman)",
    0x0D.toByte -> "Oasis Semiconductor",
    0x0E.toByte -> "Novanet Semiconductor",
    0x8F.toByte -> "E-M Solutions",
    0x10.toByte -> "Power General",
    0x91.toByte -> "Advanced Hardware Arch.",
    0x92.toByte -> "Inova Semiconductors GmbH",
    0x13.toByte -> "Telocity",
    0x94.toByte -> "Delkin Devices",
    0x15.toByte -> "Symagery Microsystems",
    0x16.toByte -> "C-Port Corporation",
    0x97.toByte -> "SiberCore Technologies",
    0x98.toByte -> "Southland Microsystems",
    0x19.toByte -> "Malleable Technologies",
    0x1A.toByte -> "Kendin Communications",
    0x9B.toByte -> "Great Technology Microcomputer",
    0x1C.toByte -> "Sanmina Corporation",
    0x9D.toByte -> "HADCO Corporation",
    0x9E.toByte -> "Corsair",
    0x1F.toByte -> "Actrans System Inc.",
    0x20.toByte -> "ALPHA Technologies",
    0xA1.toByte -> "Silicon Laboratories, Inc. (Cygnal)",
    0xA2.toByte -> "Artesyn Technologies",
    0x23.toByte -> "Align Manufacturing",
    0xA4.toByte -> "Peregrine Semiconductor",
    0x25.toByte -> "Chameleon Systems",
    0x26.toByte -> "Aplus Flash Technology",
    0xA7.toByte -> "MIPS Technologies",
    0xA8.toByte -> "Chrysalis ITS",
    0x29.toByte -> "ADTEC Corporation",
    0x2A.toByte -> "Kentron Technologies",
    0xAB.toByte -> "Win Technologies",
    0x2C.toByte -> "Tezzaron Semiconductor",
    0xAD.toByte -> "Extreme Packet Devices",
    0xAE.toByte -> "RF Micro Devices",
    0x2F.toByte -> "Siemens AG",
    0xB0.toByte -> "Sarnoff Corporation",
    0x31.toByte -> "Itautec SA",
    0x32.toByte -> "Radiata Inc.",
    0xB3.toByte -> "Benchmark Elect. (AVEX)",
    0x34.toByte -> "Legend",
    0xB5.toByte -> "SpecTek Incorporated",
    0xB6.toByte -> "Hi/fn",
    0x37.toByte -> "Enikia Incorporated",
    0x38.toByte -> "SwitchOn Networks",
    0xB9.toByte -> "AANetcom Incorporated",
    0xBA.toByte -> "Micro Memory Bank",
    0x3B.toByte -> "ESS Technology",
    0xBC.toByte -> "Virata Corporation",
    0x3D.toByte -> "Excess Bandwidth",
    0x3E.toByte -> "West Bay Semiconductor",
    0xBF.toByte -> "DSP Group",
    0x40.toByte -> "Newport Communications",
    0xC1.toByte -> "Chip2Chip Incorporated",
    0xC2.toByte -> "Phobos Corporation",
    0x43.toByte -> "Intellitech Corporation",
    0xC4.toByte -> "Nordic VLSI ASA",
    0x45.toByte -> "Ishoni Networks",
    0x46.toByte -> "Silicon Spice",
    0xC7.toByte -> "Alchemy Semiconductor",
    0xC8.toByte -> "Agilent Technologies",
    0x49.toByte -> "Centillium Communications",
    0x4A.toByte -> "W.L. Gore",
    0xCB.toByte -> "HanBit Electronics",
    0x4C.toByte -> "GlobeSpan",
    0xCD.toByte -> "Element 14",
    0xCE.toByte -> "Pycon",
    0x4F.toByte -> "Saifun Semiconductors",
    0xD0.toByte -> "Sibyte, Incorporated",
    0x51.toByte -> "MetaLink Technologies",
    0x52.toByte -> "Feiya Technology",
    0xD3.toByte -> "I & C Technology",
    0x54.toByte -> "Shikatronics",
    0xD5.toByte -> "Elektrobit",
    0xD6.toByte -> "Megic",
    0x57.toByte -> "Com-Tier",
    0x58.toByte -> "Malaysia Micro Solutions",
    0xD9.toByte -> "Hyperchip",
    0xDA.toByte -> "Gemstone Communications",
    0x5B.toByte -> "Anadigm (Anadyne)",
    0xDC.toByte -> "3ParData",
    0x5D.toByte -> "Mellanox Technologies",
    0x5E.toByte -> "Tenx Technologies",
    0xDF.toByte -> "Helix AG",
    0xE0.toByte -> "Domosys",
    0x61.toByte -> "Skyup Technology",
    0x62.toByte -> "HiNT Corporation",
    0xE3.toByte -> "Chiaro",
    0x64.toByte -> "MDT Technologies GmbH",
    0xE5.toByte -> "Exbit Technology A/S",
    0xE6.toByte -> "Integrated Technology Express",
    0x67.toByte -> "AVED Memory",
    0x68.toByte -> "Legerity",
    0xE9.toByte -> "Jasmine Networks",
    0xEA.toByte -> "Caspian Networks",
    0x6B.toByte -> "nCUBE",
    0xEC.toByte -> "Silicon Access Networks",
    0x6D.toByte -> "FDK Corporation",
    0x6E.toByte -> "High Bandwidth Access",
    0xEF.toByte -> "MultiLink Technology",
    0x70.toByte -> "BRECIS",
    0xF1.toByte -> "World Wide Packets",
    0xF2.toByte -> "APW",
    0x73.toByte -> "Chicory Systems",
    0xF4.toByte -> "Xstream Logic",
    0x75.toByte -> "Fast-Chip",
    0x76.toByte -> "Zucotto Wireless",
    0xF7.toByte -> "Realchip",
    0xF8.toByte -> "Galaxy Power",
    0x79.toByte -> "eSilicon",
    0x7A.toByte -> "MorphicsTechnology",
    0xFB.toByte -> "Accelerant Networks",
    0x7C.toByte -> "Silicon Wave",
    0xFD.toByte -> "SandCraft",
    0xFE.toByte -> "Elpida"
  )
}
