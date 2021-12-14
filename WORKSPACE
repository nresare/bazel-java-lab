workspace(name="bazel-java-lab")
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
       "io.vavr:vavr:0.10.4",
       "org.apache.logging.log4j:log4j-api:2.16.0",
       "org.apache.logging.log4j:log4j-core:2.16.0",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
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