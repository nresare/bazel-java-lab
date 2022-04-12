package com.resare.lab;

import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VavrCollectionsTest {
    @Test
    void testMakeSet() {
        var projects = List.of("a", "b", "c");

        var projectSet = HashSet.ofAll(projects);
        assertTrue(projectSet.contains("b"));
    }
}
