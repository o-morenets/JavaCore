package _23_java_8_features._04_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamToIterable {

    public static void main(String[] args) {
        streamIterator(Arrays.asList("One", "Two", "Three"));
    }

    private static void streamIterator(List<String> listOfStrings) {
        Stream<String> stringStream = listOfStrings.stream();

        // this does not compile
//        for (String eachString : stringStream.iterator()) {
//            System.out.println(eachString);
//        }

        for (String eachString : getIterable(stringStream)) {
            System.out.println(eachString);
        }
    }

    private static Iterable<String> getIterable(Stream<String> stringStream) {
        return () -> stringStream.iterator();
    }
}
