package _18_java_8_features._00_functional_interfaces.functions_demo;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class IntBinaryOperatorDemo {

	public static void main(String[] args) {
		IntBinaryOperator intBinaryOperator = (left, right) -> left * right;

		int factorial = IntStream.range(1, 11)
				.reduce(1, intBinaryOperator);

		System.out.println("10! = " + factorial);
	}
}
