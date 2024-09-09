package _18_collections._03_set;

import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * TreeSet uses Comparator which always returns 0
 * As a result, different objects (by equals() method which is not used here) are considered as equal and only one can be added
 */
public class TreeSetWithConstantComparator {

    public static void main(String[] args) {

        IntStream.of(23, 23, 17)
                .collect(() -> new TreeSet<>((o1, o2) -> 0), TreeSet::add, TreeSet::addAll)
                .forEach(System.out::println); // 23 (only one element)
    }
}
