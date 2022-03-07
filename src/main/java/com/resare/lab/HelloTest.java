package com.resare.lab;

import io.vavr.collection.List;
import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloTest {

    @Test
    public void myTest() {
        //fail("I am failing now");
    }

    @Test
    void testOptionListFlattening() {
        var l = List.of(Option.of("first"), Option.none(), Option.of("second"));
        assertEquals(List.of("first", "second"), l.flatMap(v -> v));

        var another = java.util.List.of(Optional.of("first"), Optional.empty(), Optional.of("second"));
        assertEquals(
                java.util.List.of("first", "second"),
                another.stream().flatMap(Optional::stream).collect(Collectors.toList())
        );
    }
}