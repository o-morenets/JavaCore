package _17_collections._00_collection;

import java.util.ArrayList;
import java.util.List;

public class IterateAndRemoveWithNoError {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D"); // <-- can be removed without throwing java.util.ConcurrentModificationException
		list.add("E");

		for (String s : list) {
			// cursor = 0 size = 5 --> hasNext() succeeds and next() also succeeds without exception.
			// cursor = 1 size = 5 --> hasNext() succeeds and next() also succeeds without exception.
			// cursor = 2 size = 5 --> hasNext() succeeds and next() also succeeds without exception.
			// cursor = 3 size = 5 --> hasNext() succeeds and next() also succeeds without exception.
			if ("D".equals(s)) {
				// removing any other element but "D" throws java.util.ConcurrentModificationException
				list.remove(s);
			}
			// cursor = 4 size = 4 --> hasNext() does not succeed and next() is skipped.
			// checkForComodification() is invoked in next()
		}

		System.out.println(list);
	}
}
