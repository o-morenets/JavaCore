package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongToDoubleFunction;
import java.util.stream.LongStream;

public class LongToDoubleFunctionDemo {

	public static void main(String[] args) {

		// long -> double
		LongToDoubleFunction longBy10dividerFunction = value -> value / 10.0;

		LongStream.range(0, 10)
				.mapToDouble(longBy10dividerFunction)
				.forEach(System.out::println);
	}
}
