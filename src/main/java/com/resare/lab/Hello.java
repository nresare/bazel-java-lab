package com.resare.lab;

import io.vavr.collection.List;

public class Hello {
    public static void main(String[] args) {
        var s = List.of("Hello", "world")
                .foldLeft("", (agg, cur) -> "".equals(agg) ? cur : agg + ", " + cur);
        System.out.println(s);
    }
}
