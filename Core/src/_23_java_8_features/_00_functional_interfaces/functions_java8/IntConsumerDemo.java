package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class IntConsumerDemo {

	public static void main(String[] args) {

		// int -> void
		IntConsumer intPrinter = System.out::println;

		IntStream.of(5, 2, 8, 4, 7)
				.forEachOrdered(intPrinter);
	}
}
