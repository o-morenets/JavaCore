package stackOverflow;

import java.util.ArrayList;
import java.util.List;

/**
 * https://ru.stackoverflow.com/questions/860487/java-list-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4-%D0%B8%D0%B7-%D0%B4%D1%80%D1%83%D0%B3%D0%BE%D0%B3%D0%BE-%D0%B2%D0%BE%D0%BF%D1%80%D0%BE%D1%81%D0%B0-%D0%BA%D0%B0%D0%BA-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D1%82%D0%B8%D1%82%D1%8C
 */
public class Types {
    public static List<Integer> din(int number) {
        String n = Integer.toString(number);
        char[] charArray = n.toCharArray();
        List<Integer> cia = new ArrayList<Integer>();
        for (int i = 0; i < charArray.length; i++) {
            int c = Character.getNumericValue(charArray[i]);
            cia.add(c);
            System.out.println(cia.get(i));
        }
        return cia;
    }


    public static void main(String[] args) throws Exception {
        din(310);  // или любое другое целое число типа int
    }
}
