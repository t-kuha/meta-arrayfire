#
# ArrayFire
#

SUMMARY = "arrayfire"
DESCRIPTION = "ArrayFire: a general purpose GPU library."

SRCREV = "b59a1ae535da369db86451e5b28a7bc0eaf3e84a"
PV = "3.9.0"
PR = "r0"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=2ef03bdc6636fab53f073d7fab4c162c"

S = "${WORKDIR}/git"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI = "\
    git://github.com/arrayfire/arrayfire.git;protocol=https;branch=master \
    file://0001-Add-support-for-Yocto-build.patch \
"

DEPENDS += " boost openblas fftw bin2cpp-native"

inherit cmake

# allow git fetch during do_configure()
do_configure[network] = "1"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DAF_BUILD_CPU=ON -DAF_BUILD_CUDA=OFF \
    -DAF_BUILD_OPENCL=OFF -DAF_BUILD_UNIFIED=OFF \
    -DAF_BUILD_EXAMPLES=OFF -DBUILD_TESTING=OFF \
"

do_install:append () {
    cp -R ${B}/extern/spdlog-build/libspdlog.so* ${D}/usr/lib
}

FILES:${PN} += " \
    ${prefix}/LICENSES/* \
    ${prefix}/share/* \
    ${prefix}/lib/libafcpu.debug \
"
