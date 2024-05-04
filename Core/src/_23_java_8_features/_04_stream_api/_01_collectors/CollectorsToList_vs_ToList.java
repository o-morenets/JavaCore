package _23_java_8_features._04_stream_api._01_collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToList_vs_ToList {

    public static void main(String[] args) {

        List<Integer> modifiableList = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toList()); // normal ArrayList
        modifiableList.add(42); // allowed

        List<Integer> unmodifiableList = Stream.of(1, 2, 3, 4, 5)
                .toList(); // unmodifiable ArrayList
        unmodifiableList.add(42); // not allowed
    }
}
