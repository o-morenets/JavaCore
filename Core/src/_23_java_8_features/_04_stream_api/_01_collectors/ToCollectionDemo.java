package _23_java_8_features._04_stream_api._01_collectors;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToCollectionDemo {

    /**
     * Collect to a specific collection type (everything that inherits from Collection)
     */
    public static void main(String[] args) {
        Stream.of("apple", "banana", "cherry", "apple")
                .collect(Collectors.toCollection(ArrayList::new))
                .forEach(System.out::println); // ["apple", "banana", "cherry", "apple"]

        System.out.println("-".repeat(10));
        Stream.of("apple", "banana", "cherry", "apple")
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(System.out::println); // ["apple", "banana", "cherry"]

        System.out.println("-".repeat(10));
        Stream.of("apple", "banana", "cherry", "apple")
                .collect(Collectors.toCollection(PriorityQueue::new))
                .forEach(System.out::println); // ["apple", "apple", "banana", "cherry"]
    }
}
