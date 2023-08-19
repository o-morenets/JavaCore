package _00_types._01_char;

/**
 * char type
 * Created by Oleksii on 20.07.2017.
 */
public class Char {

    public static void main(String[] args) {

        /* char - number representation */

        char charDec, charBin, charOct, charHex;

        // decimal
        charDec = 65535;
        System.out.println((int) charDec); //65535

        // binary
        charBin = 0b11111111_11111111; // positive, because char is unsigned
        System.out.println((int) charBin); //65535

        // octal
        charOct = 0177777;
        System.out.println((int) charOct); //65535

        // hexadecimal
        charHex = 0xffff;
        System.out.println((int) charHex); //65535

        System.out.println("Range of char: " + (int) Character.MIN_VALUE + ".." + (int) Character.MAX_VALUE); // Range of char: 0..65535

        /* char - character representation */

        // character
        char ch = 'F'; // character 'F'
        System.out.println(ch); // F
        ch = 'A' + 5; // character 'F'
        System.out.println(ch); // F

        // decimal
        ch = 70; // character 'F'
        System.out.println(ch); // F

        // octal
        ch = '\106'; // character 'F'
        System.out.println(ch); // F

        // hexadecimal
        ch = '\u0046'; // character 'F'
        System.out.println(ch); // F

        // escape characters
        ch = '\\'; // character '\'
        System.out.println(ch); // \

		/* System.out.println('\u000d'); // invalid char constant - \u000d - even in comment like this (uncomment block- to see) */

        // Removing the space character leads to syntax error, even in comment -> "c:\ users"

        // see also http://ru.wikipedia.org/wiki/UTF-16)

        byte b = (byte) 0b10000001;
        System.out.println("b = " + b); // -127
        b <<= 1;
        System.out.println("b = " + b); // 2
        System.out.println("b = " + (b << 1)); // 4
    }
}
