package _18_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.LongConsumer;
import java.util.stream.LongStream;

public class LongConsumerDemo {

	public static void main(String[] args) {
		LongConsumer longConsumer = System.out::println;

		LongStream.range(-5, 5)
				.forEach(longConsumer);
	}
}
