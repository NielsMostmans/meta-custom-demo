SUMMARY = "Demo hello world file."
LICENSE = "CLOSED"

SRC_URI = "file://src"

S = "${WORKDIR}/src"

do_compile() {
        ${CXX} ${CXXFLAGS} ${LDFLAGS} -o hello_cpp hello.cpp
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 hello_cpp ${D}${bindir}
}

