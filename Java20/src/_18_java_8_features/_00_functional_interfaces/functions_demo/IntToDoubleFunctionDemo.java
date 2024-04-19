package _18_java_8_features._00_functional_interfaces.functions_demo;

import java.util.function.IntToDoubleFunction;
import java.util.stream.IntStream;

public class IntToDoubleFunctionDemo {

	public static void main(String[] args) {
		IntToDoubleFunction intToDoubleFunction = value -> 1.0 / value;

		IntStream.range(0, 10)
				.mapToDouble(intToDoubleFunction)
				.forEach(System.out::println);
	}
}
