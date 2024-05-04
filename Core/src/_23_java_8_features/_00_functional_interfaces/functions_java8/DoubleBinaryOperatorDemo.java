package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public class DoubleBinaryOperatorDemo {

	public static void main(String[] args) {
		DoubleBinaryOperator doubleBinaryOperator = ((left, right) -> left + right);

		double[] arr = {2.0, 1.0, 0.0, 3.0};

		Arrays.parallelPrefix(arr, doubleBinaryOperator);
		System.out.println(Arrays.toString(arr)); // [2.0, 3.0, 3.0, 6.0]
	}
}
