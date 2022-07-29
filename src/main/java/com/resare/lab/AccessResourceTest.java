package com.resare.lab;

import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccessResourceTest {
    @Test
    void testAccessMissingResources() throws Exception {
        assertNotNull(this.getClass().getClassLoader().getResource("swaggerTemplateOverloads/test.mustache"));
    }
}
