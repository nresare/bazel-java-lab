package com.resare.lab;

import com.google.devtools.build.runfiles.Runfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Greeter {
    public static String greeting() {
        try {
            var path = Runfiles.create().rlocation("__main__/src/main/resources/greeting.txt");
            return Files.readString(Path.of(path));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
