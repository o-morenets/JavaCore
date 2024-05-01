
package stackOverflow.hashTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

//        HashMapImpl<Integer, String> hashMap = new HashMapImpl<>();
        Scanner in = new Scanner(System.in, "windows-1251");
        System.out.print("Введите слово для проверки: ");
        String num = in.nextLine();
        System.out.print(num);
        File f = new File("text1.txt");
        final int length = (int) f.length();

        String s = "";

        if (length != 0) {
            char[] cbuf = new char[length];
            InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "windows-1251");
            final int read = isr.read(cbuf);
            String EXAMPLE_TEST = new String(cbuf, 0, read);
            // System.out.println(EXAMPLE_TEST);
            isr.close();

            Pattern pattern =
                    Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
                            | Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(EXAMPLE_TEST);
            SortedSet<String> words = new TreeSet<>();

            while (matcher.find())
                words.add(matcher.group().toLowerCase());

            for (String word : words)
                System.out.println("word = " + word);

            int n = 0;
            for (String word : words) {
//                hashMap.put(n, word);
                n++;
                s = word;
            }

            System.out.println(s);
            System.out.println(num);


        }
        System.out.println(s.equals(num));

//        System.out.println("Hashmap has value at null:" + hashMap.containsValue(s));

//        System.out.println("Hashmap has value at null:" + hashMap.containsValue(num));

//        System.out.println("Hashmap has value at null:" + hashMap.containsValue("что"));
    }
}
