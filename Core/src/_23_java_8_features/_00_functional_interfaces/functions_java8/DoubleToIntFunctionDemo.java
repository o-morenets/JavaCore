package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.DoubleToIntFunction;
import java.util.stream.DoubleStream;

public class DoubleToIntFunctionDemo {

	public static void main(String[] args) {
		DoubleToIntFunction doubleToIntFunction = Math::getExponent;

		DoubleStream.of(5.54, 1.23456789, 9)
				.mapToInt(doubleToIntFunction)
				.forEach(System.out::println);
	}
}
