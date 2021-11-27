package com.resare.lab;

import io.vavr.collection.List;

public class Hello {
    public static void main(String[] args) {
        var s = List.of("Hello", "world")
                .foldLeft("", (agg, cur) -> "".equals(agg) ? cur : agg + ", " + cur);
        System.out.println(s);
        castSyntax("foo");
        castSyntax("bar");
    }

    private static void castSyntax(Object o) {
        if (o instanceof String s) {
            acceptString(s);
        }
    }

    private static void acceptString(String s) {
        System.out.printf("Got a string: %s%n", s);
    }
}
