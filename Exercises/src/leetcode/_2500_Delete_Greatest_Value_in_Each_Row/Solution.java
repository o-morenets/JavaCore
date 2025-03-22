package leetcode._2500_Delete_Greatest_Value_in_Each_Row;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2500. Delete Greatest Value in Each Row
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given an m x n matrix grid consisting of positive integers.
 * <p>
 * Perform the following operation until grid becomes empty:
 * <p>
 * Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
 * Add the maximum of deleted elements to the answer.
 * Note that the number of columns decreases by one after each operation.
 * <p>
 * Return the answer after performing the operations described above.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,2,4],[3,3,1]]
 * Output: 8
 * Explanation: The diagram above shows the removed values in each step.
 * - In the first operation, we remove 4 from the first row and 3 from the second row (notice that, there are two cells with value 3 and we can remove any of them). We add 4 to the answer.
 * - In the second operation, we remove 2 from the first row and 3 from the second row. We add 3 to the answer.
 * - In the third operation, we remove 1 from the first row and 1 from the second row. We add 1 to the answer.
 * The final answer = 4 + 3 + 1 = 8.
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[10]]
 * Output: 10
 * Explanation: The diagram above shows the removed values in each step.
 * - In the first operation, we remove 10 from the first row. We add 10 to the answer.
 * The final answer = 10.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 100
 */
public class Solution {
    public int deleteGreatestValue(int[][] grid) {
        Queue<Integer>[] pqs = new PriorityQueue[grid.length];
        for (int r = 0; r < grid.length; r++) {
            pqs[r] = new PriorityQueue<>(Comparator.reverseOrder());
            // PriorityQueue has another constructor which accepts a Collection and then heapify() it,
            // but in that case we cannot set reverseOrder Comparator
            pqs[r].addAll(Arrays.stream(grid[r]).boxed().toList()); // unfortunately, addAll() add elements one by one
        }
        int answer = 0;
        for (int c = 0; c < grid[0].length; c++) {
            int max = 0;
            for (Queue<Integer> pq : pqs) {
                int rowMax = pq.poll();
                if (rowMax > max) {
                    max = rowMax;
                }
            }
            answer += max;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}}));
    }
}
