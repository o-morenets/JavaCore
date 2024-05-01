package stackOverflow.listJoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListJoin
{
	public static void main(String[] args)
	{
		List<String> resultList = new ArrayList<>();
		final int maxLength = 25;

		List<String> list = Arrays.asList(
				"XXXXXXXXXXXXXXXXXXXXXXXX",
				"YYYYYYYYY",
				"ZZZZZZZZZ",
				"RRRRRRRRR",
				"",
				"1",
				"22",
				"333",
				"4444",
				"55555",
				"EEEEEEEEEEEEEEEEEEEEEEEE",
				"1"
		);

		int currentIndex = 0;
		while (currentIndex < list.size()) {
			String currentElement = list.get(currentIndex);
			int currentLength = currentElement.length();

			while (currentLength <= maxLength && ++currentIndex < list.size()) {
				String nextElement = list.get(currentIndex);
				currentLength += nextElement.length();
				if (currentLength <= maxLength) {
					currentElement += nextElement;
				} else {
					break;
				}
			}
			resultList.add(currentElement);
		}

		System.out.println(resultList);
	}
}
