package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.DoubleConsumer;

public class DoubleConsumerDemo {

	public static void main(String[] args) {

		// double -> void
		DoubleConsumer doublePrinter = value -> {
			System.out.println("Processing double value: " + value);
		};

		doublePrinter.accept(42.0);
	}
}
