package _18_collections._99_examples;

import java.util.HashSet;
import java.util.Set;

/**
 * add(T value)
 * but
 * remove(Object o)
 */
public class ShortSet {

	public static void main(String[] args) {
		Set<Short> s = new HashSet<>();
		for (short i = 0; i < 100; i++) {
			s.add(i);
			s.remove(i - 1); // note that IDEA knows the issue: Set<Short> may not contain objects of type int
		}
		System.out.println(s.size()); // 100
	}
}
