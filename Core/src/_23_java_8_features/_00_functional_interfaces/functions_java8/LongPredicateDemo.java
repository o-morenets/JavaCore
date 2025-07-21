package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class LongPredicateDemo {

	public static void main(String[] args) {

		// long -> boolean
		LongPredicate evenTester = value -> value % 2 == 0;

		LongStream.range(0, 10)
				.filter(evenTester)
				.forEach(System.out::println);
	}
}
