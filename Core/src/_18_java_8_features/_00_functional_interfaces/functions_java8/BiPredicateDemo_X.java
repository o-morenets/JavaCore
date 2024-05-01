package _18_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.BiPredicate;

public class BiPredicateDemo_X {

	public static void main(String[] args) {
		 BiPredicate<String, Integer> biPredicate = (str, len) -> str.length() >= len;
	}
}
