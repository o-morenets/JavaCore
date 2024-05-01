package stackOverflow.parseStrings;

//import java.io.FileReader;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.COMMA;

public class ParseStrings
{
/*
	public static List<String[]> readFile(String SOURCE_FILE)
	{
		List<String[]> stringList = new ArrayList<>();
		final CSVParser csvParser = new CSVParserBuilder().withSeparator(COMMA).build();
		try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(SOURCE_FILE)).withCSVParser(csvParser).withSkipLines(1).build())
		{
			stringList = csvReader.readAll();
		}
		catch (final Exception ex)
		{
			ex.printStackTrace();
		}
		return stringList;
	}
*/

	void findFirm(List<String[]> dataItems)
	{
		Pattern ALFA_MOBILE = Pattern.compile("ALFA_MOBILE");
		Pattern Ryabin = Pattern.compile("Ryabin");
		for (String[] strings : dataItems)
		{
			Matcher matcherALFA_MOBILE = ALFA_MOBILE.matcher(strings[5]);
			Matcher matcherRyabin = Ryabin.matcher(strings[5]);
			String companyName = "";
			if (matcherALFA_MOBILE.find())
			{
				companyName = strings[5].substring(matcherALFA_MOBILE.start(), matcherALFA_MOBILE.end());
			} else if (matcherRyabin.find())
			{
				companyName = strings[5].substring(matcherRyabin.start(), matcherRyabin.end());
			}
			strings[5] = companyName;
			String s = Arrays.stream(strings).collect(Collectors.joining(" "));
		}
	}
}
