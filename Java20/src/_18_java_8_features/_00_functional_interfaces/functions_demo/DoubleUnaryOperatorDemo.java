package _18_java_8_features._00_functional_interfaces.functions_demo;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class DoubleUnaryOperatorDemo {

	public static void main(String[] args) {
		DoubleUnaryOperator doubleUnaryOperator = Math::ceil;

		DoubleStream.of(-3.3, -2.2, -1.1, 0.0, 1.1, 2.2, 3.3)
				.map(doubleUnaryOperator)
				.forEach(System.out::println);
	}
}
