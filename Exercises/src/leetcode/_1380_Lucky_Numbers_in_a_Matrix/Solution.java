package leetcode._1380_Lucky_Numbers_in_a_Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380. Lucky Numbers in a Matrix
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * <p>
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 2:
 * <p>
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 * <p>
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 * Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 105.
 * All elements in the matrix are distinct.
 */
public class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minsInRow = new int[m];
        for (int r = 0; r < m; r++) {
            int min = matrix[r][0];
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] < min) {
                    min = matrix[r][c];
                }
            }
            minsInRow[r] = min;
        }
        List<Integer> res = new ArrayList<>();
        for (int c = 0; c < n; c++) {
            int max = matrix[0][c];
            int maxRowIdx = 0;
            for (int r = 0; r < m; r++) {
                if (matrix[r][c] > max) {
                    max = matrix[r][c];
                    maxRowIdx = r;
                }
            }
            if (max == minsInRow[maxRowIdx]) {
                res.add(max);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}})); // [15]
        System.out.println(solution.luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}})); // [12]
        System.out.println(solution.luckyNumbers(new int[][]{{7, 8}, {1, 2}})); // [7]
    }
}
