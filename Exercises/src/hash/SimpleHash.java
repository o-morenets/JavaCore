package hash;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class SimpleHash {

    public static void main(String[] args) {
        IntStream.rangeClosed(10, 99).forEach(num -> System.out.println(num + ": " + hash(num)));
    }

    private static int hash(int number) {
        int result = number;
        while (result > 9) {
            result = addAllDigits(result);
        }
        return result;
    }

    private static int addAllDigits(int number) {
        Integer[] digits = getDigits(number);
        int resultHash = 0;
        for (Integer digit : digits) {
            resultHash += digit;
        }
        return resultHash;
    }

    private static Integer[] getDigits(int number) {
        Deque<Integer> digits = new ArrayDeque<>();
        int currentNumber = number;
        while (currentNumber != 0) {
            int lastDigit = currentNumber % 10;
            digits.addFirst(lastDigit);
            currentNumber /= 10;
        }
        return digits.toArray(new Integer[0]);
    }
}
