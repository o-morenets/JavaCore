
package stackOverflow.sumDigits;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumDigits {

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(100, 999)
                .map(i -> Arrays.stream(String.valueOf(i).split(""))
                        .mapToInt(Integer::parseInt).sum())
                .filter(sum -> sum % 13 == 0);

        intStream.forEach(System.out::println);
    }
}
