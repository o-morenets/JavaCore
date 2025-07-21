package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.ObjIntConsumer;

public class ObjIntConsumerDemo {

	public static void main(String[] args) {

		// T, int -> void
		 ObjIntConsumer<String> stringIntPrinter = (s, i) -> System.out.println("String: " + s + ", Integer: " + i);

		 stringIntPrinter.accept("Hello", 42);
	}
}
