package _18_java_8_features._00_functional_interfaces.functions_demo;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class LongPredicateDemo {

	public static void main(String[] args) {
		LongPredicate longPredicate = value -> value % 2 == 0;

		boolean isAllEven = LongStream.range(0, 10)
				.allMatch(longPredicate);

		System.out.println("isAllEven = " + isAllEven);
	}
}
