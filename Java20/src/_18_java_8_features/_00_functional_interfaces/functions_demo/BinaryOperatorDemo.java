package _18_java_8_features._00_functional_interfaces.functions_demo;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinaryOperatorDemo {

	public static void main(String[] args) {

		// BinaryOperator<T> binaryOperator;
		BinaryOperator<Integer> binaryOperator = (v1, v2) -> v1 + v2;

		Map<Character, Integer> charsFreqMap = "abcbbccbab".chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.toMap(Function.identity(), v -> 1, binaryOperator));

		System.out.println("charsFreqMap = " + charsFreqMap);
	}
}
