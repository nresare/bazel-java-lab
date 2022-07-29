package com.resare.lab;

import io.vavr.Tuple2;
import io.vavr.collection.HashMap;
import io.vavr.collection.LinkedHashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiLevelMapTest {
    @Test
    void multiLevelMapTest() {
        var input  = List.of(
                new Tuple2<>("dir1/file1", "content"),
                new Tuple2<>("dir2/file1", "content"),
                new Tuple2<>("dir2/file2", "content")
        );
        //input.map(item -> item._1.split("/")[0]).forEach(System.out::println);

        var result = input.groupBy(MultiLevelMapTest::getTopDir);

        assertEquals(
            LinkedHashMap.of(
                    "dir1", List.of(new Tuple2<>("dir1/file1", "content")),
                    "dir2", List.of(new Tuple2<>("dir2/file1", "content"), new Tuple2<>("dir2/file2", "content"))
            ),
            result
        );
    }

    private static String getTopDir(Tuple2<String, String> item) {
        return item._1.split("/", 2)[0];
    }
}
