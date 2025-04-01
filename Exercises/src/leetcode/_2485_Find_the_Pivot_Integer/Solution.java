package leetcode._2485_Find_the_Pivot_Integer;

import java.util.stream.IntStream;

/**
 * 2485. Find the Pivot Integer
 * Easy
 * Topics
 * Companies
 * Hint
 * Given a positive integer n, find the pivot integer x such that:
 *
 * The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
 * Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 8
 * Output: 6
 * Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 is the pivot integer since: 1 = 1.
 * Example 3:
 *
 * Input: n = 4
 * Output: -1
 * Explanation: It can be proved that no such integer exist.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 */
public class Solution {
    public int pivotInteger(int n) {
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + i;
        }
        int x = -1;
        for (int i = n; i > 0; i--) {
            int left = sum[i - 1];
            int right = sum[n] - sum[i];
            if (left == right) {
                x = i;
                break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotInteger(8)); // 6
        System.out.println(solution.pivotInteger(1)); // 1
        System.out.println(solution.pivotInteger(4)); // -1

        for (int i = 0; i < 1000; i++) {
            int n = i + 1;
            int result = solution.pivotInteger(n);
            if (result != -1) {
                System.out.println("n: " + n + ", pivot: " + result);
            }
        }
    }
}
