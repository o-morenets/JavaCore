package epam._2026_09_03_tech_interview;

/**
 * 03/09/2026
 * Tech interview EPAM
 *
 * Reverse number
 * 123 -> 321
 * -123 -> -321
 * 120 -> 21
 */
public class Solution {

    /**
     * My solution - accepted
     */
    private static int reverseSB(int num) {
        StringBuilder sb = new StringBuilder();

        int sign = Math.abs(num);
        sb.append(sign);
        sb.reverse();

        return num > 0 ? Integer.valueOf(sb.toString()) : -Integer.valueOf(sb.toString());
    }

    /**
     * More efficient solution
     */
    private static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-120)); // -21
        System.out.println(reverse(123));  // 321
        System.out.println(reverse(-123)); // -321
        System.out.println(reverse(120));  // 21

        System.out.println(reverseSB(-120)); // -21
        System.out.println(reverseSB(123));  // 321
        System.out.println(reverseSB(-123)); // -321
        System.out.println(reverseSB(120));  // 21
    }
}
