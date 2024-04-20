package _18_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.DoubleFunction;
import java.util.stream.DoubleStream;

public class DoubleFunctionDemo {

	public static void main(String[] args) {
		DoubleFunction<DoubleStream> doubleFunction = value -> DoubleStream
				.iterate(value, operand -> operand + 1)
				.limit(3);

		DoubleStream.of(5.2, 1.0, 3.1)
				.flatMap(doubleFunction)
				.forEach(System.out::println);
	}
}
