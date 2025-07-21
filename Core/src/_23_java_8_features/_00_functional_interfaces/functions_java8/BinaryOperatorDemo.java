package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinaryOperatorDemo {

	public static void main(String[] args) {

		// T, T -> T
		BinaryOperator<Integer> mergeFunction = (v1, v2) -> v1 + v2;

		Map<Character, Integer> charsFreqMap = "ababagalamaga".chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.toMap(Function.identity(), v -> 1, mergeFunction));

		System.out.println("charsFreqMap = " + charsFreqMap);
	}
}
