package _18_collections._04_map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapWithAccessOrder {

    public static void main(String[] args) {
        // initial capacity = 5
        // loadFactor = 1 means the inner array won't grow
        // accessOrder = true - more recently accessed elements move to the end
        Map<Integer, String> map = new LinkedHashMap<>(5, 1, true);
        fillMap(map);

        // note the order we access the elements:
        map.get(3);
        map.get(5);
        map.get(1);
        System.out.println("map = " + map); // map = {4=E, 2=C, 3=D, 5=F, 1=B} - recently accessed element is in the end
    }

    private static void fillMap(Map<Integer, String> map) {
        for (int i = 5; i >= 1; i--) {
            map.put(i, String.valueOf(Character.valueOf((char) ('A' + i))));
        }
    }
}
