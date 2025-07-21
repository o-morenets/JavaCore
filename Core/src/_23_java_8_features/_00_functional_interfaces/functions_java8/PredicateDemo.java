package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateDemo {

	public static void main(String[] args) {

		// T -> boolean
		Predicate<String> greaterThan2stringLengthTester = s -> s.length() > 2;

		Stream.of("1", "02", "003")
				.filter(greaterThan2stringLengthTester)
				.forEach(System.out::println);
	}
}
