package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.Objects;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {

		// () -> T
		Supplier<String> supplier = () -> "NULL!";

		Object o = Objects.requireNonNull(null, supplier); // Exception in thread "main" java.lang.NullPointerException: NULL!
		System.out.println("o = " + o);
	}
}
