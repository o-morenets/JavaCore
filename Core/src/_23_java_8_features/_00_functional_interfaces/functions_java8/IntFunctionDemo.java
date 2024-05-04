package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class IntFunctionDemo {

	public static void main(String[] args) {
		IntFunction<IntStream> intFunction = value -> IntStream.range(0, value);

		IntStream.of(5, 7, 2, 1, 9)
				.flatMap(intFunction)
				.forEach(System.out::println);
	}
}
