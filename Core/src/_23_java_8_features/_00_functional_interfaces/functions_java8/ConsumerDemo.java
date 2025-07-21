package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerDemo {

	public static void main(String[] args) {

		// T -> void
		Consumer<String> stringPrinter = System.out::println;

		Stream.of("a1", "a2", "a3")
				.forEach(stringPrinter);
	}
}
