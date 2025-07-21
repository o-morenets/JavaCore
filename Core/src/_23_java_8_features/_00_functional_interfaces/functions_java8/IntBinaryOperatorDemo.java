package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class IntBinaryOperatorDemo {

	public static void main(String[] args) {

		// int, int -> int
		IntBinaryOperator multiplierFunction = (left, right) -> left * right;

		int factorial = IntStream.rangeClosed(1, 10)
				.reduce(1, multiplierFunction);

		System.out.println("10! = " + factorial);
	}
}
