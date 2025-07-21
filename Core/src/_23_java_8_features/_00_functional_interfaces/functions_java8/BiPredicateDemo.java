package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

	public static void main(String[] args) {

		// T, U -> boolean
		BiPredicate<String, Integer> stringLengthTester = (str, len) -> str.length() >= len;

		String testString = "Hello, World!";
		int minLength = 5;
		boolean result = stringLengthTester.test(testString, minLength);
		System.out.println("Does the string \"" + testString + "\" have a length of at least " + minLength + "? " + result);
	}
}
