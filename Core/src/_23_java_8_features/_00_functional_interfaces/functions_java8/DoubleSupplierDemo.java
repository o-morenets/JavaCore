package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.OptionalDouble;
import java.util.function.DoubleSupplier;

public class DoubleSupplierDemo {

	public static void main(String[] args) {
		DoubleSupplier doubleSupplier = Math::random;

		OptionalDouble optionalDouble = OptionalDouble.empty();
		double d = optionalDouble.orElseGet(doubleSupplier);
		System.out.println("d = " + d);
	}
}
