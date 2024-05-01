package stackOverflow.mapSortByValue;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, Product> map = new TreeMap<>();
        map.put("B", new Product("A4", "B"));
        map.put("C", new Product("B2", "C"));
        map.put("A", new Product("C3", "A"));

        for(Product item : map.values()){
            System.out.println(item.getName());
        }

        map.values().stream()
                .sorted(Comparator.comparing(Product::getName))
                .forEach(System.out::println);

        map.entrySet().stream()
                .sorted(Comparator.comparing(o -> o.getValue().getName()))
                .forEach(System.out::println);

        Map<String, Double> map1 = new HashMap<>();
        map1.put("five", 5D);
        map1.put("six", 6D);
        map1.put("one", 1D);
        map1.put("two", 2D);
        map1.put("zero", 0D);

        map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

        map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}
