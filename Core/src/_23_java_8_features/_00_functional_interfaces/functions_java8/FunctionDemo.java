package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionDemo {

	public static void main(String[] args) {

		// Function<T, R> function;
		Function<String, Integer> function = s -> Integer.parseInt(s.substring(1));

		Stream.of("a1", "b2", "c3")
				.map(function)
				.forEach(System.out::println);
	}
}
