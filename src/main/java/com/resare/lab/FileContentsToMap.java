package com.resare.lab;


import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.collection.Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileContentsToMap {
    public static Map<String, String> getFileContents(Path root) throws IOException {
        return Stream.ofAll(Files.walk(root))
                .filter(p -> p.toFile().isFile())
                .map(file -> readFile(file, root))
                .collect(HashMap.collector());
    }

    private static Tuple2<String, String> readFile(Path path, Path root) {
        try {
            return new Tuple2<>(root.relativize(path).toString(), Files.readString(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
