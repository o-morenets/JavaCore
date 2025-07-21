package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongToIntFunction;
import java.util.stream.LongStream;

public class LongToIntFunctionDemo {

    public static void main(String[] args) {
        
        // long -> int
        LongToIntFunction longBy2Divider = longValue -> (int) (longValue / 2);

        LongStream.range(1_000_000, 10_000_000)
                .limit(10)
                .mapToInt(longBy2Divider)
                .forEach(System.out::println);
    }
}