package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DB {
    private static final String FILE_NAME = "output.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void save(String text) {
        try {
            String filePath = Paths.get("src", "main", "resources", FILE_NAME).toString();
            File file = new File(filePath);
            if (file == null) {
                file.createNewFile();
            }
            List<String> messages = read();
            messages.add(text);

            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
                objectMapper.writeValue(writer, messages);
            }

            System.out.println("Message saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while saving data.");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> read() {
        String filePath = Paths.get("src", "main", "resources", FILE_NAME).toString();
        File file = new File(filePath);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            return objectMapper.readValue(reader, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, String.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
