package _13_interfaces._05_functional_interfaces._99_samples;

import java.util.function.BiPredicate;

public class BiPredicateDemo_X {

	public static void main(String[] args) {
		 BiPredicate<String, Integer> biPredicate = (str, len) -> str.length() >= len;
	}
}
