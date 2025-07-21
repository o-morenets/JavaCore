package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class DoubleUnaryOperatorDemo {

	public static void main(String[] args) {

		// double -> double
		DoubleUnaryOperator ceilOperator = Math::ceil;

		DoubleStream.of(-3.3, -2.2, -1.1, 0.0, 1.1, 2.2, 3.3)
				.map(ceilOperator)
				.forEach(System.out::println);
	}
}
