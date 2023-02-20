package it.figuccia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Start {
    public static void main(String[] args) {
        File file = new File("src/it/figuccia/Date.txt");

        // check if the file exists
        if (file.exists()) {
            System.out.println("The file already exists. Overwriting it...");
        } else {
            System.out.println("The file does not exist. Creating it...");
        }

        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            // write the date/time to file using streams
            new FileOutputStream(file).getChannel().write(java.nio.charset.Charset.defaultCharset().encode(formattedDateTime));

            System.out.println("Successfully wrote the date/time to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }
}