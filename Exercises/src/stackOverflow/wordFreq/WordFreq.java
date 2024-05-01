package stackOverflow.wordFreq;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFreq
{
	public static void main(String[] args) throws IOException
	{
		try (Stream<String> lines = Files
				.lines(Paths.get("freq.txt")))
		{
			lines
					.flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+")))
					.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
					.entrySet()
					.stream()
					.sorted((e1, e2) ->
					{
						if (e1.getValue().equals(e2.getValue()))
						{
							return e1.getKey().compareTo(e2.getKey());
						} else
						{
							return e2.getValue().compareTo(e1.getValue());
						}
					})
					.limit(10)
					.forEach(e -> System.out.println(e.getKey()));
		}
	}
}
