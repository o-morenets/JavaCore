package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.Objects;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<String> supplier = () -> "NULL!";

		Object o = Objects.requireNonNull(null, supplier); // NPE

		System.out.println("o = " + o);
	}
}
