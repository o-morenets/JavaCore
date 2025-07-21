package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.ObjDoubleConsumer;
import java.util.stream.IntStream;

public class ObjDoubleConsumerDemo {

	public static void main(String[] args) {

		// T, double -> void
		 ObjDoubleConsumer<IntStream> intStreamMultiplierPrinter = (stream, value) -> stream.forEach(i -> {
             double result = i * value; // Example operation: multiply each int by the double value
             System.out.println("Int: " + i + ", Multiplied by Double: " + value + " = " + result);
         });

		 // Create an IntStream and apply the ObjDoubleConsumer
		 IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
		 double doubleValue = 2.5; // Example double value
		 intStreamMultiplierPrinter.accept(intStream, doubleValue);

		 // Output:
		 // Int: 1, Multiplied by Double: 2.5 = 2.5
		 // Int: 2, Multiplied by Double: 2.5 = 5.0
		 // Int: 3, Multiplied by Double: 2.5 = 7.5
		 // Int: 4, Multiplied by Double: 2.5 = 10.0
		 // Int: 5, Multiplied by Double: 2.5 = 12.5
	}
}
