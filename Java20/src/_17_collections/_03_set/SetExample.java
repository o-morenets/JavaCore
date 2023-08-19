package _17_collections._03_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>(Arrays.asList("First", "2nd", "# Three"));
        ArrayList<String> stringArrayList = new ArrayList<>(stringSet);
        stringSet.forEach(System.out::println);
        System.out.println("stringArrayList = " + stringArrayList);
    }
}
