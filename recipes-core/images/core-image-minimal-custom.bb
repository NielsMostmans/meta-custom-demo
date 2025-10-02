SUMMARY = "Custom core-image-minimal recipe"
DESCRIPTION = "Core image minimal including custom executables." 
LICENSE = "MIT"

python do_display_banner() {
    bb.plain("**************************************");
    bb.plain("*                                    *");
    bb.plain("* Custom core-image-minimal loading! *");
    bb.plain("*                                    *");
    bb.plain("**************************************");
}

addtask display_banner before do_build

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

inherit core-image
inherit extrausers

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

EXTRA_IMAGE_FEATURES += "ssh-server-dropbear"
IMAGE_INSTALL += " net-tools"

EXTRA_IMAGE_FEATURES:remove = "debug-tweaks"

EXTRA_USERS_PARAMS = "\
    usermod -p '\$6\$V3HlmFUjClntZhGO\$sZQ9MXsuuvXeDr.uVojI9yQZALVooHVgp62JSlTbR0OWv2WsaY49GNO3LL4Ub8s0M3pqPYdKrESmGqzFcvjeU1' root; \
    useradd -p '\$6\$c9ShYs8qA8uvm3yv\$3GdDXlZGds4BBd7.zFvAivIkChZSh7N8lkj2qpPY9jYlAv/7c5iErBMxzEuefev6rhn8/ZB5NpjrkhWGT0NUl/' niels; \
"
IMAGE_INSTALL += "hello"
