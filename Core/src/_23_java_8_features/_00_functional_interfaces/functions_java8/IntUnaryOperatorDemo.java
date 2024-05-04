package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class IntUnaryOperatorDemo {

	public static void main(String[] args) {
		IntUnaryOperator intUnaryOperator = i -> i * i;

		int[] arr = new int[20];
		Arrays.setAll(arr, intUnaryOperator);
		System.out.println(Arrays.toString(arr));
	}
}
