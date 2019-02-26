# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-graphics/imx-gpu-viv/imx-gpu-viv-6.inc
LIC_FILES_CHKSUM = "file://COPYING;md5=6dfb32a488e5fd6bae52fbf6c7ebb086"

SRC_URI[md5sum] = "d5529f8b6a6db1714f996a0de0b0858a"
SRC_URI[sha256sum] = "832d75095d746083bab13cefb0ab27e2da3930eadc215b8f2994d8cd02e387ab"

PACKAGE_FP_TYPE = "hardfp"

COMPATIBLE_MACHINE = "(mx6q|mx6dl|mx6sx|mx6sl|mx7ulp)"
