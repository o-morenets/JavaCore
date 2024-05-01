package stackOverflow.sortDistinct;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortDistinct {

    public static void main(String[] args) {
        String result = Arrays.stream("zxxyyab".toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> String.valueOf(e.getKey()))
                .sorted()
                .collect(Collectors.joining());

        System.out.println(result);
    }
}
