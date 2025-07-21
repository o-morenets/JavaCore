package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntPredicateDemo {

	public static void main(String[] args) {

		// int -> boolean
		IntPredicate lessThan50intTester = value -> value < 50;

		IntStream.generate(() -> (int) (Math.random() * 100))
				.limit(10)
				.filter(lessThan50intTester)
				.forEach(System.out::println);
	}
}
