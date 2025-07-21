package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.DoubleFunction;
import java.util.stream.DoubleStream;

public class DoubleFunctionDemo {

	public static void main(String[] args) {

		// double -> DoubleStream
		DoubleFunction<DoubleStream> doubleStreamCreator = seed -> DoubleStream
				.iterate(seed, operand -> operand + 1)
				.limit(3);

		// Using the DoubleFunction to create a DoubleStream starting from 5.2 and incrementing by 1 for 3 elements
		DoubleStream.of(5.2, 1.0, 3.1)
				.flatMap(doubleStreamCreator)
				.forEach(System.out::println);
	}
}
