package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class LongSupplierDemo {

	public static void main(String[] args) {

		// () -> long
		LongSupplier longRandomGenerator = () -> (long) ((Math.random() * 1_000_000));

		LongStream.generate(longRandomGenerator)
				.limit(5)
				.forEach(System.out::println);
	}
}
