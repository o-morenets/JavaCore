package _18_java_8_features._00_functional_interfaces.functions_demo;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateDemo {

	public static void main(String[] args) {
		Predicate<String> predicate = s -> s.length() > 2;

		Stream.of("1", "02", "003")
				.filter(predicate)
				.forEach(System.out::println);
	}
}
