package _18_java_8_features._00_functional_interfaces.functions_demo;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BiFunctionDemo {

	public static void main(String[] args) {

		// BiFunction<T, U, R> biFunction;
		BiFunction<Character, Integer, Integer> biFunction = (k, v) -> v > 3 ? -1 : v;

		Map<Character, Integer> charFreqMap = "abcbbccbab".chars()
				.mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity()))
				.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));
		System.out.println("charFreqMap = " + charFreqMap);

		charFreqMap.replaceAll(biFunction);
		System.out.println("charFreqMap = " + charFreqMap);
	}
}
