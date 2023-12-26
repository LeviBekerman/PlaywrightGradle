package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

    public static <T> T[] mergeArrays(T[]... TArrays) {
        List<T> list = new ArrayList<>();
        Arrays.stream(TArrays).forEach(ts -> {
            if (ts.length > 0)
                list.addAll(Arrays.asList(ts));
        });
        return (T[]) list.toArray();
    }
}
