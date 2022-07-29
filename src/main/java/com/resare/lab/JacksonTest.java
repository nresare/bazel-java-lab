package com.resare.lab;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.vavr.jackson.datatype.VavrModule;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JacksonTest {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new VavrModule())
            .enable(SerializationFeature.INDENT_OUTPUT)
            .enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);

    private record Foo (String baz, String bar) {}

    //@Test
    void testRenderJson() throws Exception {
        assertEquals(
            """
            {
              "ralf" : "first"
              "mardrom" : "second",
            }""",

            MAPPER.writeValueAsString(Map.of("mardrom", "first", "ralf", "second"))
        );
    }

    @Test
    void testSplitOnDot() {
        var v = "foo.bar.baz";

    }

}
