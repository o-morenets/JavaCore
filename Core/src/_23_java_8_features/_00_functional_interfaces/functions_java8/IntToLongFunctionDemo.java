package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.Arrays;
import java.util.function.IntToLongFunction;
import java.util.stream.IntStream;

public class IntToLongFunctionDemo {

	public static void main(String[] args) {
		IntToLongFunction intToLongFunction = value ->
				IntStream
						.rangeClosed(1, value)
						.reduce(1, (left, right) -> left * right);

		long[] arr = new long[20];
		Arrays.setAll(arr, intToLongFunction);
		System.out.println(Arrays.toString(arr));
	}
}
