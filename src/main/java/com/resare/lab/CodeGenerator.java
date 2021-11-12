package com.resare.lab;

import io.swagger.codegen.v3.cli.SwaggerCodegen;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class CodeGenerator {
    private static final Yaml YAML = new Yaml();

    public static void main(String[] args) throws IOException {
        System.out.println("from the code generator");
        getAll(Paths.get("/tmp/pubsub_v1beta1_pubsubtopic.yaml"));
    }

    private static void getAll(Path path) throws IOException  {
        try (var input = Files.newInputStream(path)) {
//            var v = StreamSupport.stream(YAML.loadAll(input).spliterator(), false)
//                    .map(CodeGenerator::extractSchema)
//                    .collect(Collectors.toList());
//            var specFile = Files.createTempFile("spec", "yaml");
//            System.out.println("specFile: " + specFile);
//            try (var output = Files.newBufferedWriter(specFile)) {
//                YAML.dump(buildSpec(extractSchema(YAML.load(input))), output);
//                System.out.printf("wrote to %s\n", specFile);
//            }
            SwaggerCodegen.main(List.of(
                    "generate", "-i", "/Users/noa/fun/bazel-java-lab/petstore.json", "-o", "/tmp/tmp", "-l", "java", "--ignore-file-override=/dev/null", "--model-package", "petapi"
            ).toArray(String[]::new));
        }
    }


    @SuppressWarnings("unchecked")
    private static Map<String, Object> extractSchema(Object input) {
        var version = ((Map<String, Map<String, List<Object>>>)input).get("spec").get("versions").get(0);
        var schema =  ((Map<String, Map<String, Map<String, Object>>>)version).get("schema").get("openAPIV3Schema");

        var kind = ((Map<String, Map<String, Map<String, String>>>)input).get("spec").get("names").get("kind");
        schema.put("type", "object");
        return Map.of(kind, schema);
    }

    // build the top level spec data structure
    private static Object buildSpec(Object schema) {
        return Map.of(
                "openapi", "3.0.0",
                "info", Map.of(
                        "version", "1.0.0",
                        "title", "kcc resources",
                        "license", Map.of("name", "MIT")),
                "paths", Map.of("/dummy", Map.of()),
                "components", Map.of("schemas", List.of(schema)));
    }
}
