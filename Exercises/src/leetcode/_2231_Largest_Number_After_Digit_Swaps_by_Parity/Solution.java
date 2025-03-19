package leetcode._2231_Largest_Number_After_Digit_Swaps_by_Parity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 2231. Largest Number After Digit Swaps by Parity
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).
 * <p>
 * Return the largest possible value of num after any number of swaps.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 1234
 * Output: 3412
 * Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
 * Swap the digit 2 with the digit 4, this results in the number 3412.
 * Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
 * Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.
 * Example 2:
 * <p>
 * Input: num = 65875
 * Output: 87655
 * Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
 * Swap the first digit 5 with the digit 7, this results in the number 87655.
 * Note that there may be other sequences of swaps but it can be shown that 87655 is the largest possible number.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 109
 */
public class Solution {
    public int largestInteger(int num) {
        int[] digits = Integer.toString(num).chars()
                .map(ch -> ch - '0')
                .toArray();

        Queue<Integer> pqEven = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> pqOdd = new PriorityQueue<>(Comparator.reverseOrder());

        for (int d : digits) {
            if (d % 2 == 0) {
                pqEven.add(d);
            } else {
                pqOdd.add(d);
            }
        }

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 2 == 0) {
                digits[i] = pqEven.poll();
            } else {
                digits[i] = pqOdd.poll();
            }
        }

        return Integer.parseInt(
                Arrays.stream(digits)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining())
        );
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestInteger(1234)); // 3412
        System.out.println(solution.largestInteger(65875)); // 87655
    }
}
