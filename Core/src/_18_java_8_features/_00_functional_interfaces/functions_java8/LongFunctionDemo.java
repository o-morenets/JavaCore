package _18_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongFunction;
import java.util.stream.LongStream;

public class LongFunctionDemo {

	public static void main(String[] args) {
		LongFunction<String> longFunction = value -> "str_" + String.valueOf(value);

		LongStream.rangeClosed(1, 10)
				.mapToObj(longFunction)
				.forEach(System.out::println);
	}
}
