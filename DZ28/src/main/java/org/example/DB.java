package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DB {
    private static String FILE_NAME = "output.txt";


    public static void save(String text) {
        try {

            String filePath = Paths.get("src", "main", "resources", FILE_NAME).toString();
            File file = new File(filePath);
            file.createNewFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(text);
                writer.newLine();
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

        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}