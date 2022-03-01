package com.resare.lab;

import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.collection.Stream;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileContentsToMapTest {
    @Test
    void testGetFileContents() throws Exception {
        // given
        var dir = Files.createTempDirectory("tmpPrefix");
        Files.writeString(dir.resolve("a.txt"), "foo");
        Files.writeString(dir.resolve("b.txt"), "bar");

        // when
        var contents = FileContentsToMap.getFileContents(dir);

        // then
        assertEquals(
                HashMap.of("a.txt", "foo", "b.txt", "bar"),
                contents
        );
    }
}