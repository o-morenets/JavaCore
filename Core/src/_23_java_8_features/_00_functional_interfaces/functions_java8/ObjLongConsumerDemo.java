package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.ObjLongConsumer;

public class ObjLongConsumerDemo {

	public static void main(String[] args) {

		// T, long -> void
		 ObjLongConsumer<String> stringLongPrinter = (s, l) -> System.out.println("String: " + s + ", Long: " + l);

		 stringLongPrinter.accept("Hello", 123456789L);
	}
}
