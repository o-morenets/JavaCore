package stackOverflow.fullSearch;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

	public static HashSet<String> extractNumber(List<Task> list) {
		HashSet<String> numbers = new HashSet<>();

		// for-each
		for (Task task : list) {
			numbers.add(task.getNumber());
		}
		return numbers;
	}
}