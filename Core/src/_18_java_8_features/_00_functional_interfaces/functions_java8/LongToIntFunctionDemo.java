package _18_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongToIntFunction;
import java.util.stream.LongStream;

public class LongToIntFunctionDemo {

    public static void main(String[] args) {
        LongToIntFunction longToIntFunction = value -> (int) (value / 10);

        LongStream.range(1_000_000, 10_000_000)
                .limit(10)
                .mapToInt(longToIntFunction)
                .forEach(System.out::println);
    }
}