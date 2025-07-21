package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongConsumer;
import java.util.stream.LongStream;

public class LongConsumerDemo {

	public static void main(String[] args) {

		// long -> void
		LongConsumer longPrinter = System.out::println;

		LongStream.range(-5, 5)
				.forEach(longPrinter);
	}
}
