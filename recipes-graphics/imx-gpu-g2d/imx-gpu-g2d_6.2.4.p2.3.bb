# Copyright (C) 2016 Freescale Semiconductor
# Copyright 2017-2018 NXP
# Copyright 2018 (C) O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "GPU G2D library and apps for i.MX with 2D GPU and no DPU"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=6dfb32a488e5fd6bae52fbf6c7ebb086"

DEPENDS += "libgal-imx"
PROVIDES += "virtual/libg2d"

# FIXME: arm packages are mis-labeled with aarch32 suffix
FSLBIN_NAME     = "${PN}-${PV}-${TARGET_ARCH}"
FSLBIN_NAME_arm = "${PN}-${PV}-aarch32"

SRC_URI = "${FSL_MIRROR}/${FSLBIN_NAME}.bin;name=${TARGET_ARCH};fsl-eula=true"
SRC_URI[arm.md5sum] = "826349f67198359fddfe3e456770eb68"
SRC_URI[arm.sha256sum] = "35a5875d795190117b7fcdd43229d18576d530fddfd32f9d79e161fc7028d29d"
SRC_URI[aarch64.md5sum] = "287f2de4bd407b2eb484d332ae6de157"
SRC_URI[aarch64.sha256sum] = "77f191135f2be6052eabc8cca50b4ea7b5eaec015488cc108fb3f9656a3a1367"

S = "${WORKDIR}/${FSLBIN_NAME}"

inherit fsl-eula-unpack

do_install () {
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    cp ${S}/g2d/usr/lib/*.so* ${D}${libdir}
    cp -Pr ${S}/g2d/usr/include/* ${D}${includedir}
    cp -r ${S}/gpu-demos/opt ${D}
}

FILES_${PN} = "${libdir}/libg2d* /opt"
FILES_${PN}-dev = "${includedir}"
INSANE_SKIP_${PN} = "ldflags"

RDEPENDS_${PN} = "libgal-imx"

COMPATIBLE_MACHINE = "(imxgpu2d)"
