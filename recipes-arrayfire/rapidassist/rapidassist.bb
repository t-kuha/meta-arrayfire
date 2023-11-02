#
# rapidassist 
#   - for ArrayFire dependency
#
SUMMARY = "rapidassist"
DESCRIPTION = "RapidAssist is a lite cross-platform library that assist you with the most c++ repetitive tasks."

SRCREV = "8983e364f30774385639ca925d2cfe993718d7a0"
PV = "0.8.1"
PR = "r0"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=8f611fe11d10985c6932705594c62ee7"

S = "${WORKDIR}/git"
SRC_URI = "\
    git://github.com/end2endzone/RapidAssist.git;protocol=https;branch=master \
"

inherit cmake
DEPENDS += " gtest-native"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
"

# Enable native build
BBCLASSEXTEND = "native nativesdk"
