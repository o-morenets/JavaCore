package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.IntToDoubleFunction;
import java.util.stream.IntStream;

public class IntToDoubleFunctionDemo {

	public static void main(String[] args) {

		// int -> double
		IntToDoubleFunction intToDoubleInverseFunction = value -> 1.0 / value;

		IntStream.range(0, 10)
				.mapToDouble(intToDoubleInverseFunction)
				.forEach(System.out::println);
	}
}
