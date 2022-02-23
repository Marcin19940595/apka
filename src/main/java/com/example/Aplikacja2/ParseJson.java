package com.example.Aplikacja2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ParseJson {
    public ParseJson() throws IOException {
        File jsonFile = new File("src/main/java/parsejson/jsonExample");
        String content = readFile(jsonFile);
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(content);
        jsonNode.get("User").forEach(
                (User)->{User.get("username").get("age").forEach(
                        (item)->{System.out.println(String.format("%s: %s %s", User.get("username"), item.get("age"), item.get("city")));}
                );
                }
        );
    }

    public static String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String ls = "\n";
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        // delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        return stringBuilder.toString();
    }
}
