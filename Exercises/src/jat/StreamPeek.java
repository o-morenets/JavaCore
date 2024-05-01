package jat;

import java.util.stream.IntStream;

public class StreamPeek {
    public static void main(String[] args) {
        IntStream.range(1, 5)
                .peek(System.out::println)
                .peek(i -> {
                    if (i == 5)
                        throw new RuntimeException("bang");
                });

    }
}
