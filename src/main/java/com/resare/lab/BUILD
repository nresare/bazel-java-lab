load("@rules_junit5_external//:junit5.bzl", "java_junit5_test")

java_binary(
    name = "Hello",
    srcs = ["Hello.java", "FileContentsToMap.java"],
    deps = [
        "@maven//:io_vavr_vavr",
    ]
)

java_junit5_test(
    name = "tests",
    srcs = glob([
        "*Test.java",
    ]),
    deps = [
        "@maven//:io_vavr_vavr",
        "@maven//:io_vavr_vavr_jackson",
        "@maven//:com_google_guava_guava",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        ":Hello",
    ],
    resources = [
        "//src/main/resources:all",
    ],
    test_package = "com.resare.lab",
)

