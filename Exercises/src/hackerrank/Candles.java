package hackerrank;

import java.util.List;

public class Candles {

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        return candles.stream()
//                .mapToInt(Integer::valueOf)
//                .max()
                .reduce(Integer::sum)
                .map(i -> candles.stream()
                        .mapToInt(Integer::valueOf)
                        .filter(c -> c == i)
                        .count()
                )
                .orElse(-1L)
                .intValue();
    }
}
