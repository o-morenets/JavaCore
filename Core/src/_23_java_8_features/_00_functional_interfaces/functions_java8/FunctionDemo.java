package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionDemo {

	public static void main(String[] args) {

		// T -> R
		Function<String, Integer> numberExtractorFunction = s -> Integer.parseInt(s.substring(1));

		Stream.of("a1", "b2", "c3")
				.map(numberExtractorFunction)
				.forEach(System.out::println);
	}
}
