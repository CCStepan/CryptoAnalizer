package cryptoanalizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public String readFile(String filePath) {
        String result = "";
        Path path = Path.of(filePath);
        try {
            List<String> list = Files.readAllLines(path);

            for (String str : list)
                result = result + str;

        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }
        return result;
    }

    public void writeFile(String content, String filePath) {


        try {
            Files.createFile(Path.of(filePath));

            Path path = Path.of(filePath);
            String[] arr =content.split("\n");

            for (String str : arr) {
                Files.writeString(path, str);
            }

        } catch (IOException e) {
            System.out.println(e.fillInStackTrace());
        }

    }
}