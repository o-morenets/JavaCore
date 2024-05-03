package _18_java_8_features._04_stream_api._01_collectors;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class CollectDemo {

    /**
     * Map of Squared numbers 1..10
     */
    public static void main(String[] args) {

        LinkedHashMap<Integer, Integer> map = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(
                        LinkedHashMap::new,            // supplier
                        (lhm, i) -> lhm.put(i, i * i), // accumulator
                        HashMap::putAll                // combiner
                );
        System.out.println(map);
    }
}
