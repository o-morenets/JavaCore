package jat;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsNullKey {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "null");

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put(null, "null"); // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "k1" is null
    }
}
