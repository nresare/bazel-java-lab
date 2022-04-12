package com.resare.lab;

import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VavrControlTest {
    @Test
    void testTry() {
        var something = Try.of(() -> {
            //throw new Exception("Throwing");
            return false;
        });

        var result = something
                .mapTry(truthValue -> truthValue ? "cucumber": "banana")
                .onFailure(exception -> System.out.printf("Failed %s\n", exception))
                .get();
        assertEquals("banana", result);
    }
}
