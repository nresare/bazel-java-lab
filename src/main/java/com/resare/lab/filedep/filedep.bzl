def my_function(tool):
    native.genrule(
        name = "my_genrule",
        exec_tools = [tool],
        cmd = "$(location :ToolWithFileAccess) > $@",
        outs = ["output.txt"],
    )

