#
# ArrayFire
#

SUMMARY = "arrayfire"
DESCRIPTION = "ArrayFire: a general purpose GPU library."

SRCREV = "492718b5a256d4a9d5198fdce89d8fd21772bfda"
PV = "3.10.0"
PR = "r0"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=9ef964636d84afa818bf00a28fb1de5d"

S = "${WORKDIR}/git"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI = "\
    git://github.com/arrayfire/arrayfire.git;protocol=https;branch=master \
    file://0002-Add-support-for-Yocto-build.patch \
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
