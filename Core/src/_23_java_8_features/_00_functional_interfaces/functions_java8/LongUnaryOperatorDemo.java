package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;

public class LongUnaryOperatorDemo {

    public static void main(String[] args) {
        LongUnaryOperator longUnaryOperator = operand -> operand * 10;

        LongStream.range(0, 10)
                .map(longUnaryOperator)
                .forEach(System.out::println);
    }
}
