package epam._2019_11_08_interview_refinitiv;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringReverse {

    public static void main(String[] args) {
        String str = "ABCDE 0123456789";
        System.out.println("Original:  " + str);

        System.out.println("Inplace:     " + stringReverseInplace(str));
        System.out.println("Recursive:   " + stringReverseRecursion(str));
        System.out.println("Stack:       " + stringReverseStack(str));
        System.out.println("For reverse: " + stringReverseForReverse(str));
    }

    private static String stringReverseInplace(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }

        return String.valueOf(chars);
    }

    private static String stringReverseRecursion(String str) {
        if (str.length() == 1) {
            return str;
        }

        return stringReverseRecursion(str.substring(1)) + str.substring(0, 1);
    }

    private static String stringReverseStack(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            stack.push(ch);
        }

        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    private static String stringReverseForReverse(String str) {
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            result[result.length - 1 - i] = chars[i];
        }

        return String.valueOf(result);
    }
}
