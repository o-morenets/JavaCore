package _18_collections._04_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapVsLinkedHashMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        fillMap(map);
        System.out.println("map = " + map); // map = {1=A, 2=B, 3=C, 4=D, 5=E} - because hashCode of Integer is the number itself

        map = new LinkedHashMap<>();
        fillMap(map);
        System.out.println("map = " + map); // map = {5=E, 4=D, 3=C, 2=B, 1=A} - in the same order as we inserted
    }

    private static void fillMap(Map<Integer, String> map) {
        for (int i = 5; i >= 1; i--) {
            map.put(i, String.valueOf(Character.valueOf((char) ('A' + i - 1))));
        }
    }
}
