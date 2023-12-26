package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

public class ListUtils {
    public static <T> void removeCellsFromList(List<T> TList, List<T> TListToRemove, Predicate<T> predicate) {
        List<T> afterRemove = new ArrayList<>(TList.stream().filter(predicate).toList());
        TList.clear();
        TList.addAll(afterRemove);
    }

    public static <T> List<T> mergeLists(List<T>... TArrays) {
        List<T> list = new ArrayList<>();
        for (List<T> tArray : TArrays) {
            if (!tArray.isEmpty())
                list.add((T) asList(tArray));
        }
        return list;
    }
}
