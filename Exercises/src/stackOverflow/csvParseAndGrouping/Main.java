
package stackOverflow.csvParseAndGrouping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("test - test.csv")).skip(1);
        Map<String, Map<LocalDate, Integer>> map = groupByNameAndDate(lines);

        // print
        map.forEach((s, localDateIntegerMap) -> {
            System.out.print(s + ": ");
            localDateIntegerMap.forEach((date, numPatients) -> System.out.print(" " + date + " (" + numPatients + ")"));
            System.out.println();
        });
    }

    private static Map<String, Map<LocalDate, Integer>> groupByNameAndDate(Stream<String> lines) {
        Map<String, Map<LocalDate, Integer>> map = new TreeMap<>();
        lines.forEach(s -> {
            String[] parsedParts = s.split(",");
            String name = parsedParts[0];
            Map<LocalDate, Integer> localDateIntegerMap = map.get(name);
            if (localDateIntegerMap == null) {
                localDateIntegerMap = new TreeMap<>();
            }
            LocalDate date = LocalDate.parse(parsedParts[1], DateTimeFormatter.ofPattern("MMM dd yyyy"));
            Integer numOfPatients = localDateIntegerMap.get(date);
            if (numOfPatients == null) {
                numOfPatients = 0;
            }
            localDateIntegerMap.put(date, numOfPatients + Integer.parseInt(parsedParts[2]));
            map.put(name, localDateIntegerMap);
        });
        return map;
    }
}
