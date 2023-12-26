package utils.api;

import manage.objects.KeyValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static manage.objects.KeyValue.joinAs;

public class ApiUtils {

    public static <T> String joinParameters(Map<String, String> keyValues) {
        List<String> strings = new ArrayList<>();
        keyValues.forEach((s, s2) -> {
            strings.add(s + "=" + s2);
        });
        return String.join("&",strings);
    }

    public static <T> String joinPathAndParameters(String mainPath, Map<String, String> keyValues) {
        return mainPath + "?" + joinParameters(keyValues);
    }
}
