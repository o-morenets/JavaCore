package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongFunction;
import java.util.stream.LongStream;

public class LongFunctionDemo {

	public static void main(String[] args) {

		// long -> String
		LongFunction<String> concatFunction = value -> "str_" + value;

		LongStream.rangeClosed(1, 10)
				.mapToObj(concatFunction)
				.forEach(System.out::println);
	}
}
