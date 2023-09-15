package _16_generics._06_arrays_are_covariant;

import java.util.ArrayList;
import java.util.List;

public class DangerousArrayOfGenerics {

	public static void main(String[] args) {
		dangerousMethod(List.of("Hello"));
	}

	private static void dangerousMethod(List<String>... stringLists) {
		Object[] arr = stringLists; // allowed as arrays are covariant
		List<Integer> integerList = new ArrayList<>();
		integerList.add(10);
		arr[0] = integerList;
		String s = stringLists[0].get(0); // ClassCastException
	}
}
