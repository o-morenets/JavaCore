package stackOverflow.fullSearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FullSearchTest
{

	@Test
	void extractNumber() {
		List<Task> tasks = Arrays.asList(
				new Task("1", "First desc"),
				new Task("2", "Second desc"),
				new Task("1", "First desc")
		);
		Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
		assertEquals(FullSearch.extractNumber(tasks), expected);
	}
}