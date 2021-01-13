DESCRIPTION = "The Vulkan Samples is collection of resources to help develop optimized Vulkan applications."
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=48aa35cefb768436223a6e7f18dc2a2a"

SRC_URI = "gitsm://github.com/KhronosGroup/Vulkan-Samples.git \
           file://0001-CMakeLists.txt-do-not-hardcode-lib-as-installation-t.patch \
           file://0001-support-link-against-libatomic-if-no-built-in-atomic.patch \
           file://debugfix.patch \
           "

UPSTREAM_CHECK_COMMITS = "1"
SRCREV = "fdc8fab1a520df5566de3eda7b526b24f04e6379"

UPSTREAM_CHECK_GITTAGREGEX = "These are not the releases you're looking for"
S = "${WORKDIR}/git"

REQUIRED_DISTRO_FEATURES = 'vulkan'

inherit cmake features_check

FILES_${PN} += "${datadir}"

#
# There is code to remove the prefix CMAKE_SOURCE_DIR from __FILENAME__ paths
# used for logging with LOGE in the code. We need to make this match the value we use
# in the debug source remapping from CFLAGS
#
EXTRA_OECMAKE = "-DCMAKE_DEBUG_SRCDIR=/usr/src/debug/${PN}/${EXTENDPE}${PV}-${PR}/"