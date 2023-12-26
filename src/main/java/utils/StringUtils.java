package utils;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StringUtils {

    public static String encodingBase64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes(UTF_8));
    }

    public static String decodingBase64(String value) {
        return new String(Base64.getDecoder().decode(value), UTF_8);
    }

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\levit\\Downloads\\decos.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String mp4 = null;
        try {
            mp4 = IOUtils.toString(fis, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String encoding = encodingBase64(mp4);
        String deco = decodingBase64(encoding);
        System.out.println(deco.equals(mp4));
    }


}
