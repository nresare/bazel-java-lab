package com.resare.lab;

import io.vavr.collection.HashMap;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VavrCollectionsTest {
    @Test
    void testMakeSet() {
        var projects = List.of("a", "b", "c");

        var projectSet = HashSet.ofAll(projects);
        assertTrue(projectSet.contains("b"));
    }

    @Test
    void testRemoveUndefined() {
        assertEquals(
                List.of("a", "b"),
                List.of(Option.of("a"), Option.none(), Option.of("b"))
                        //.filter(Option::isDefined).map(Option::get));
                        .flatMap(Function.identity())
        );
    }

    private static class SFunction implements Function<String, String> {

        @Override
        public String apply(String s) {
            return s.toUpperCase();
        }
    }
    @Test
    void testParmeterizedType() {
        Function<String, String> stringStringFunction = String::toUpperCase;

        var v = List.of("a", "b").map(new SFunction());
    }

    record ContainsOptionalBool(Option<Boolean> bool) {}

    @Test
    void testOptionFlatMap() {
        var maybe = Option.of(new ContainsOptionalBool(Option.none()));
        var result = maybe.flatMap(ContainsOptionalBool::bool);
        assertEquals(Option.none(), result);
    }

    @Test
    void testMergeMaps() {
        var value = List.of(HashMap.of("a", "foo"), HashMap.of("b", "bar"));
        var flattened = value.flatMap(HashMap::iterator).collect(HashMap.collector());
        assertEquals(flattened, HashMap.of("a", "foo", "b", "bar"));
    }
}
