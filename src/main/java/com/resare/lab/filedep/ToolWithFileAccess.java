package com.resare.lab.filedep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ToolWithFileAccess {

    public static void main(String[] args) throws IOException {
        Files.list(Path.of("src/main/java/com/resare/lab/filedep/txts")).forEach(System.out::println);
        System.out.printf("I got something from the file: %s%n", getFromFile());
    }

    private static String getFromFile() throws IOException {
        var contents =  Files.readString(Path.of("src/main/java/com/resare/lab/filedep/txts/someFile.txt"));
        return contents.stripTrailing();
    }
}
