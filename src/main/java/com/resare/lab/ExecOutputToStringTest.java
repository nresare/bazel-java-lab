package com.resare.lab;

import com.google.common.io.CharStreams;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExecOutputToStringTest {
    @Test
    void testOutputToString() throws IOException {
        assertEquals("a_string", runAndCaptureOutput("/bin/echo", "a_string"));
    }

    private String runAndCaptureOutput(String ...command) {
        try {
            var process = new ProcessBuilder().command(command).start();
            var reader = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
            return CharStreams.toString(reader).stripTrailing();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
