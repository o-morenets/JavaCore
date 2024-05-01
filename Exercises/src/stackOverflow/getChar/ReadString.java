package stackOverflow.getChar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadString {
    String ss = "2+3-1";

    public char getChar() {
        Pattern p = Pattern.compile("[*\\-+/]"); //ищет совпадения
        Matcher matcher = p.matcher(this.ss);
        String teg1 = "";
        while (matcher.find())
            teg1 = matcher.group(); // ловим символ
        char n = teg1.charAt(0); //преобразовываем в char

        return n;
    }

    public int getNum1() {
        String[] arrowOfInput = this.ss.split("[+\\-*/]");
        String teg2 = arrowOfInput[0]; // ловим число1
        Integer.parseInt(teg2); //преобразовываем в int
        return 0;
    }

    public int getNum2() {
        String[] arrowOfInput = this.ss.split("[+\\-*/]"); //разделяем массив с помощью арифм. знаков
        String teg3 = arrowOfInput[1]; //ловим число2
        Integer.parseInt(teg3); //преобразовываем в int
        return 0;
    }

    public static void main(String[] args) {
        ReadString sc = new ReadString();
        System.out.println(sc.getChar());
        System.out.println(sc.getNum1());
        System.out.println(sc.getNum2());
    }
}
