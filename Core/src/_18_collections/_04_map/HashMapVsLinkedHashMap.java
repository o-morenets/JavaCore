package _18_collections._04_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapVsLinkedHashMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        fillMap(map);
        System.out.println("map = " + map); // map = {1=B, 2=C, 3=D, 4=E, 5=F} - because hashCode of Integer is the number itself

        map = new LinkedHashMap<>();
        fillMap(map);
        System.out.println("map = " + map); // map = {5=F, 4=E, 3=D, 2=C, 1=B} - in the same order as we inserted
    }

    private static void fillMap(Map<Integer, String> map) {
        for (int i = 5; i >= 1; i--) {
            map.put(i, String.valueOf(Character.valueOf((char) ('A' + i))));
        }
    }
}
