java_binary(
    name = "Hello",
    srcs = ["Hello.java"],
    deps = [
        ":greeter",
        "@bazel_tools//tools/java/runfiles",
    ],
)

java_library(
    name = "greeter",
    srcs = ["Greeter.java"],
    data = ["//src/main/resources:all"],
    deps = [
        "@bazel_tools//tools/java/runfiles",
    ],
)
