DESCRIPTION = "Robopeak Kernel Driver Sample"
HOMEPAGE = "https://github.com/robopeak/rpusbdisp.git"
SECTION = "kernel/modules"
PRIORITY = "optional"
LICENSE = "none"
RDEPENDS_rpusbdisp = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"
PR = "r0"

#SRC_URI = "https://github.com/robopeak/rpusbdisp.git"
SRC_URI = "https://github.com/robopeak/rpusbdisp/archive/master.zip"

S="${WORKDIR}/rpusbdisp-master/drivers/linux-driver"

inherit module

do_compile() {
  unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
  #oe_runmake -C ${S}/drivers/linux-driver
  oe_runmake 'MODPATH="${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/video/robopeak" ' \
             'KERNEL_SOURCE_DIR="${STAGING_KERNEL_DIR}"' \
             'KDIR="${STAGING_KERNEL_DIR}"' \
             'KERNEL_VERSION="${KERNEL_VERSION}"' \
             'CC="${KERNEL_CC}"' \
             'LD="${KERNEL_LD}"'
}


do_install() {
   install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/video/robopeak
   install -m 0644 ${S}/rp_usbdisplay*${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/video/robopeak
}


SRC_URI[md5sum] = "909462b29078cc0b7268bc6a67fec406"
SRC_URI[sha256sum] = "ccff73d0daf4d5e0f0c40efd6778536f74907e469c0dc870e117f7bf1a7168ac"

LIC_FILES_CHKSUM = "file://../../LICENSE;md5=4326bf94c79e51e9d3f8d7c106fa0fde"
