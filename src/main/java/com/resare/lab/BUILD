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
        "@maven//:com_google_guava_guava",
        ":Hello",
    ],
    test_package = "com.resare.lab",
)

