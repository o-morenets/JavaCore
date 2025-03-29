package leetcode._3174_Clear_Digits;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 3174. Clear Digits
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given a string s.
 *
 * Your task is to remove all digits by doing this operation repeatedly:
 *
 * Delete the first digit and the closest non-digit character to its left.
 * Return the resulting string after removing all digits.
 *
 * Note that the operation cannot be performed on a digit that does not have any non-digit character to its left.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 *
 * Output: "abc"
 *
 * Explanation:
 *
 * There is no digit in the string.
 *
 * Example 2:
 *
 * Input: s = "cb34"
 *
 * Output: ""
 *
 * Explanation:
 *
 * First, we apply the operation on s[2], and s becomes "c4".
 *
 * Then we apply the operation on s[1], and s becomes "".
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s consists only of lowercase English letters and digits.
 * The input is generated such that it is possible to delete all digits.
 */
class Solution {
    public String clearDigits(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar) && Character.isLetter(stack.peek())) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.clearDigits("abc")); // abc
        System.out.println(solution.clearDigits("cb34")); // ""
    }
}