package leetcode._821_Shortest_Distance_to_a_Character;

import java.util.*;

/**
 * 821. Shortest Distance to a Character
 * Easy
 * Topics
 * Companies
 * Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.
 * <p>
 * The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 * Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
 * The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
 * The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
 * For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
 * The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
 * Example 2:
 * <p>
 * Input: s = "aaab", c = "b"
 * Output: [3,2,1,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s[i] and c are lowercase English letters.
 * It is guaranteed that c occurs at least once in s.
 */
public class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        Deque<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                indexes.add(i);
            }
        }

        int[] answer = new int[chars.length];
        int left = -1;
        int right;
        while (!indexes.isEmpty()) {
            right = indexes.pollFirst();
            fillAnswer(answer, left, right);
            left = right;
        }
        right = chars.length;
        fillAnswer(answer, left, right);

        return answer;
    }

    private void fillAnswer(int[] answer, int left, int right) {
        if (left == -1) {
            for (int i = right; i >= 0; i--) {
                answer[i] = right - i;
            }
        } else if (right == answer.length) {
            for (int i = left; i < answer.length; i++) {
                answer[i] = i - left;
            }
        } else {
            int halfRange = (right - left) / 2 + 1;
            for (int i = 0; i < halfRange; i++) {
                answer[i + left] = i;
                answer[right - i] = i;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestToChar("loveleetcode", 'e'))); // [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
        System.out.println(Arrays.toString(solution.shortestToChar("aaab", 'b'))); // [3, 2, 1, 0]
    }
}
