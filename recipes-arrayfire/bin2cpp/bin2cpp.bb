#
# bin2cpp 
#   - for ArrayFire dependency
#
SUMMARY = "bin2cpp"
DESCRIPTION = "bin2cpp: The easiest way to embed small files into a c++ executable."

SRCREV = "df91013c68b4560272503892cea7e38dc3c5d213"
PV = "3.0.0"
PR = "r0"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=8f611fe11d10985c6932705594c62ee7"

S = "${WORKDIR}/git"
SRC_URI = "\
    git://github.com/end2endzone/bin2cpp.git;protocol=https;branch=master \
"

inherit cmake
DEPENDS += " gtest-native rapidassist-native"

EXTRA_OECMAKE = "\
    -DBIN2CPP_BUILD_TEST=OFF \
    -DCMAKE_BUILD_TYPE=Release \
"

# Enable native build
BBCLASSEXTEND = "native nativesdk"
