package stackOverflow.isSquareInt;

import java.util.stream.LongStream;

public class SquareInt {

    public static void main(String[] args) {
        LongStream.range(0, 1_000)
                .filter(SquareInt::isSquare)
                .forEach(System.out::println);
    }

    private static boolean isSquare(long n) {
        return Math.round(Math.sqrt(n)) == Math.sqrt(n);
    }
}
