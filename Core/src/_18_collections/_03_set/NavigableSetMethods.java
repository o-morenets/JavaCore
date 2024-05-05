package _18_collections._03_set;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NavigableSetMethods {

    public static void main(String[] args) {
        TreeSet<Integer> set = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));

        Integer lower = set.lower(5);
        Integer higher = set.higher(5);
        Integer floor = set.floor(5);
        Integer ceiling = set.ceiling(5);

        System.out.println("strictly lower than 5 : " + lower);
        System.out.println("strictly higher than 5 : " + higher);
        System.out.println("less than or equal to 5 : " + floor);
        System.out.println("greater than or equal to 5 : " + ceiling);

        NavigableSet<Integer> descendingSet = set.descendingSet();
        System.out.println("descendingSet = " + descendingSet);
        // or
        NavigableSet<Integer> reversed = set.reversed();
        System.out.println("reversed = " + reversed);

        SortedSet<Integer> headSet = set.headSet(5); // 5 not included
        System.out.println("headSet = " + headSet);

        NavigableSet<Integer> tailSet = set.tailSet(5, true); // 5 included
        System.out.println("tailSet = " + tailSet);
    }
}
