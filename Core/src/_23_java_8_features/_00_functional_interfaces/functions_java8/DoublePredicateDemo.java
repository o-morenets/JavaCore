package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

public class DoublePredicateDemo {

	public static void main(String[] args) {
		DoublePredicate doublePredicate = value -> value > 50.0;

		DoubleStream.of(99.54, 25.42, 23.24)
				.filter(doublePredicate)
				.forEach(System.out::println);
	}
}
