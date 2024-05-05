package _18_collections._04_map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) {
        Map<Object, Long> weakMap = new WeakHashMap<>();
        Object o = new Object(); // o has Strong reference on object
        weakMap.put(o, 100500L);

        o = null; // no more strong references on o
        System.out.println("map = " + weakMap); // should be empty here
        System.gc(); // explicitly invoke GC

        int i;
        for (i = 0; i < 1000; i++) {
            if (weakMap.isEmpty()) {
                break;
            }
        }

        System.out.println("Step " + i + ": map = " + weakMap); // should be empty here
    }
}
