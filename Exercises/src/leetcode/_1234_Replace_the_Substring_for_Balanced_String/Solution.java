package leetcode._1234_Replace_the_Substring_for_Balanced_String;

import java.util.Arrays;

/**
 * 1234. Replace the Substring for Balanced String
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * You are given a string s of length n containing only four kinds of characters: 'Q', 'W', 'E', and 'R'.
 * <p>
 * A string is said to be balanced if each of its characters appears n / 4 times where n is the length of the string.
 * <p>
 * Return the minimum length of the substring that can be replaced with any other string of the same length to make s balanced. If s is already balanced, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "QWER"
 * Output: 0
 * Explanation: s is already balanced.
 * Example 2:
 * <p>
 * Input: s = "QQWE"
 * Output: 1
 * Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
 * Example 3:
 * <p>
 * Input: s = "QQQW"
 * Output: 2
 * Explanation: We can replace the first "QQ" to "ER".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == s.length
 * 4 <= n <= 105
 * n is a multiple of 4.
 * s contains only 'Q', 'W', 'E', and 'R'.
 */
public class Solution {

    public int balancedString(String s) {
        int target = s.length() / 4;
        int[] counts = new int[4]; // 0-Q, 1-W, 2-E, 3-R

        for (int i = 0; i < s.length(); i++) {
            counts[index(s.charAt(i))]++;
        }

        if (isBalanced(counts, target)) {
            return 0;
        }

        int left = 0;
        int answer = s.length();

        for (int right = 0; right < s.length(); right++) {
            counts[index(s.charAt(right))]--;

            while (left <= right && isWindowValid(counts, target)) {
                answer = Math.min(answer, right - left + 1);

                counts[index(s.charAt(left))]++;
                left++;
            }
        }

        return answer;
    }

    private boolean isBalanced(int[] counts, int target) {
        return Arrays.stream(counts).allMatch(count -> count == target);
    }

    private boolean isWindowValid(int[] counts, int target) {
        return Arrays.stream(counts).allMatch(i -> i <= target);
    }

    private int index(char c) {
        return switch (c) {
            case 'Q' -> 0;
            case 'W' -> 1;
            case 'E' -> 2;
            case 'R' -> 3;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.balancedString(\"QWER\") = " + solution.balancedString("QWER")); // 0 (already balanced)
        System.out.println("solution.balancedString(\"QQWE\") = " + solution.balancedString("QQWE")); // 1
        System.out.println("solution.balancedString(\"QQQW\") = " + solution.balancedString("QQQW")); // 2
    }
}
