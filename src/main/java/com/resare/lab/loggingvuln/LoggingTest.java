package com.resare.lab.loggingvuln;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingTest {

    private static final Logger logger = LogManager.getLogger(LoggingTest.class);
    public static void main(String[] args) {
        logger.error("This is a message: {}", "${java:version}");
        System.out.println("hello, world");
    }
}
