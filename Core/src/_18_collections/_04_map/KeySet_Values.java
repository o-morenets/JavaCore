package _18_collections._04_map;

import java.util.*;

public class KeySet_Values {

    public static void main(String[] args) {
        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1, "A");
        integerStringMap.put(2, "B");
        integerStringMap.put(3, "C");
        integerStringMap.put(4, "B");
        integerStringMap.put(5, "B");
        integerStringMap.put(6, null);
        integerStringMap.put(7, "B");
        integerStringMap.put(8, "B");
        integerStringMap.put(9, null);
        integerStringMap.put(99, null);
        System.out.println("integerStringMap = " + integerStringMap);

        // remove entry by key
        integerStringMap.remove(1);
        System.out.println("integerStringMap = " + integerStringMap);

        // remove only if both key and value are present
        integerStringMap.remove(8, "B");
        System.out.println("integerStringMap = " + integerStringMap);

        // remove by key from keySet()
        integerStringMap.keySet().remove(9); // changes to the map are reflected in the set, and vice versa
        System.out.println("integerStringMap = " + integerStringMap);

        // remove the first occurrence of "B"
        // values() creates mutable view over map (but add() not allowed)
        integerStringMap.values().remove("B"); // removes only first occurrence of "B"
        System.out.println("integerStringMap = " + integerStringMap);

        // remove all occurrences of "B"
        integerStringMap.values().removeIf("B"::equals);
        System.out.println("integerStringMap = " + integerStringMap);

        // remove all null values
        integerStringMap.values().removeAll(Collections.singleton(null));
        System.out.println("integerStringMap = " + integerStringMap);
    }
}
