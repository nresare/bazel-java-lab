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
       "io.swagger.codegen.v3:swagger-codegen-cli:3.0.29",
       "org.yaml:snakeyaml:1.29",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
