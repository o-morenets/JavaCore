package _18_java_8_features._04_stream_api._02_matchers;

import java.util.stream.IntStream;

public class AllMatch {

	public static void main(String[] args) {
		System.out.println(
				IntStream.range(0, 10)
						.peek(System.out::println)
						.allMatch(i -> i < 10)
		); // true
	}
}
