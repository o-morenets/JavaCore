package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

public class LongBinaryOperatorDemo {

	public static void main(String[] args) {
		LongBinaryOperator longBinaryOperator = (left, right) ->
				left % 2 == 0 ? left + right : right - left;

		long result = LongStream.range(0, 10)
				.reduce(longBinaryOperator)
				.orElseGet(() -> -1);

		System.out.println("result = " + result);
	}
}
