package practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap {
    public static void main(String[] args) {
        Map<String, String> unsortMap = new HashMap<>();
        unsortMap.put("z", "z");
        unsortMap.put("b", "b");
        unsortMap.put("a", "a");
        unsortMap.put("c", "c");
        unsortMap.put("d", "d");
        unsortMap.put("e", "e");
        unsortMap.put("y", "y");
        unsortMap.put("n", "n");
        unsortMap.put("g", "g");
        unsortMap.put("m", "m");
        unsortMap.put("f", "f");

        Map<String, String> sortMap = unsortMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map<String, String> result2 = new LinkedHashMap<>();
        unsortMap.entrySet()
                .stream()
                .sorted((Map.Entry.comparingByValue()))
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        for(Map.Entry<String, String> e: sortMap.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
