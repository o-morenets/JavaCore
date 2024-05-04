package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class IntSupplierDemo {

	public static void main(String[] args) {
		IntSupplier intSupplier = () -> (int) (Math.random() * 100);

		IntStream.generate(intSupplier)
				.limit(10)
				.forEach(System.out::println);
	}
}
