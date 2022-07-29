# The maven setup is copied from https://github.com/bazelbuild/rules_jvm_external/blob/master/README.md

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "4.1"
RULES_JVM_EXTERNAL_SHA = "f36441aa876c4f6427bfb2d1f2d723b48e9d930b62662bf723ddfb8fc80f0140"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
       "io.vavr:vavr:0.10.3",
       "io.vavr:vavr-jackson:0.10.3",
       "com.google.guava:guava:31.0.1-jre",
       "com.fasterxml.jackson.core:jackson-databind:2.13.3",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
    fetch_sources = True,
)

# end maven setup

JUNIT5_RULES_EXTERNAL_COMMMIT = "0e3deb86424483e28127172518649eb2fdbb9111"
JUNIT5_RULES_EXTERNAL_SHA = "1349c6274d9dd8f1a7f0f20de433a59ef750139a448d51852a74e9c07bf8413a"

http_archive(
    name = "rules_junit5_external",
    strip_prefix = "junit5-samples-%s/junit5-jupiter-starter-bazel" % JUNIT5_RULES_EXTERNAL_COMMMIT,
    url = "https://github.com/junit-team/junit5-samples/archive/%s.tar.gz" % JUNIT5_RULES_EXTERNAL_COMMMIT,
    sha256 = JUNIT5_RULES_EXTERNAL_SHA
)

load("@rules_junit5_external//:junit5.bzl", "junit_jupiter_java_repositories", "junit_platform_java_repositories")

junit_jupiter_java_repositories()
junit_platform_java_repositories()