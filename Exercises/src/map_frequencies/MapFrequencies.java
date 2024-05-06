package map_frequencies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapFrequencies {

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10))
                .limit(50)
                .boxed()
                .collect(Collectors.toList());
        Map<Integer, Integer> freq = groupByCounting(numbers);
        System.out.println("freq = " + freq);
    }

    private static Map<Integer, Integer> groupByCounting(List<Integer> numbers) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (Integer number: numbers) {
            Integer count = freq.get(number); // get the previous count for this number
            if (count == null) {
                count = 0; // if not in map, previous count is zero
            }
            freq.put(number, 1 + count); // (re)assign new count for this number
        }

        return freq;
    }
}
