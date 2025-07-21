package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.DoubleToLongFunction;
import java.util.stream.DoubleStream;

public class DoubleToLongFunctionDemo {

	public static void main(String[] args) {

		// double -> long
		DoubleToLongFunction roundFunction = Math::round;

		DoubleStream.of(5.54, 1.23456789, 9)
				.mapToLong(roundFunction)
				.forEach(System.out::println);
	}
}
