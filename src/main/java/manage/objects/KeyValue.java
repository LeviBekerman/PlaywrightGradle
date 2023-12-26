package manage.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class KeyValue<T> {
    String key;
    T value;

    public KeyValue(String key, T value){
        this.key = key;
        this.value = value;
    }
    public static <T> String joinAs(KeyValue<T> keyValue, String joinAs) {
        return keyValue.key + joinAs + keyValue.value;
    }

    public static <T> List<String> joinAs(List<KeyValue<T>> keyValues, String joinAs) {
        return keyValues.stream().map(keyValue -> joinAs(keyValue, joinAs)).toList();
    }

    public static <T> Map<String, T> convertToMap(KeyValue<T> keyValue) {
        return Map.of(keyValue.key, keyValue.value);
    }

    public static <T> Map<String, T> convertToMap(List<KeyValue<T>> keyValues) {
        return keyValues.stream()
                .collect(Collectors.toMap(o -> o.key, o -> o.value));
    }
}
