package _23_java_8_features._04_stream_api._00_streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Distinct method example in Stream Api
 * <p>
 * Created by vedenin on 17.10.15.
 */
public class DistinctTests {

	private static void testDistinct() {
		System.out.println();
		System.out.println("Test distinct start");
		Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
		Collection<String> nonOrdered = new HashSet<>(ordered);

		// Get collection without duplicate
		List<String> distinct = nonOrdered.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println("distinct = " + distinct); // print  distinct = [a1, a2, a3]

		List<String> distinctOrdered = ordered.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println("distinctOrdered = " + distinctOrdered); // print  distinct = [a1, a2, a3]
	}

	public static void main(String[] args) throws Exception {
		testDistinct();
	}
}
