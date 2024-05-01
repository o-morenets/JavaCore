package stackOverflow;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class sortByCount {

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 2, 4, 5, 8, 2);

/*
        List<Integer> result0 = input0
                .stream()
                .filter(x -> input0.stream().filter(x::equals).count() > 1)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result0);
*/

/*
        List<Integer> result = input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(result);
*/

        List<Integer> result2 = input.stream()
                .filter(i -> input.indexOf(i) != input.lastIndexOf(i))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result2);
    }
}
