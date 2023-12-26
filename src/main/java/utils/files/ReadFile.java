package utils.files;

import java.io.*;
import java.util.List;

public class ReadFile {

    /*
     * Return content file as view in notepad
     */
    public static String contentFile(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return String.join("\n", new BufferedReader(fileReader).lines().toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
