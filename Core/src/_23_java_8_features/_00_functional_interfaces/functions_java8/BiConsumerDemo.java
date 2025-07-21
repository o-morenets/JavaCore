package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BiConsumerDemo {

	public static void main(String[] args) {

		// T, U -> void
		BiConsumer<Character, Integer> keyValuePrinter = (k, v) -> System.out.println(k + ": " + v);

		"ababagalamaga".chars()
				.mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity()))
				.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()))
				.forEach(keyValuePrinter);
	}
}
