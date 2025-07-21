package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class IntFunctionDemo {

	public static void main(String[] args) {

		// int -> IntStream
		IntFunction<IntStream> intStreamCreator = value -> IntStream.range(0, value);

		IntStream.of(5, 7, 2, 1, 9)
				.flatMap(intStreamCreator)
				.forEach(System.out::println);
	}
}
