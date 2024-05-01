package stackOverflow.sortByOccurrences;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(116, 101, 116, 104, 101, 116);

        // отображение число->количество дубликатов
        List<Integer> integerStream = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(integerStream);
    }
}
