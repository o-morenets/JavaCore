
package stackOverflow.stringParseAndSort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringParseAndSort {

    static String parseAndSortLetters(String str) {
        String result = "";
        int current = 0;
        int end = str.length();
        while (current < end) {
            int start = current;
            while (current < end && Character.isAlphabetic(str.charAt(current))) {
                current++;
            }
            String substring = str.substring(start, current).toLowerCase();
            String sortedSubstring = Stream.of(substring.split("")).sorted().collect(Collectors.joining());
            result += sortedSubstring;

            while (current < end && !Character.isAlphabetic(str.charAt(current))) {
                result += str.charAt(current);
                current++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(parseAndSortLetters("Great43 WA1Y"));
        System.out.println(parseAndSortLetters(""));

        // приводим строку к нижнему регистру
        String str = "Great43 WA1Y".toLowerCase();

// получаем отсортированный лист с буквами
        List<Character> list = IntStream.range(0, str.length())
                .mapToObj(str::charAt)
                .filter(Character::isAlphabetic)
                .sorted()
                .collect(Collectors.toList());

// раздвигаем лист с буквами, добавляем
// небуквенные символы на прежние места
        IntStream.range(0, str.length())
                .filter(i -> !Character.isAlphabetic(str.charAt(i)))
                .forEach(i -> list.add(i, str.charAt(i)));

// вывод в строку
        list.forEach(System.out::print);
    }
}
