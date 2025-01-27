package leetcode._2373_Largest_Local_Values_in_a_Matrix;

import java.util.Arrays;

/**
 * 2373. Largest Local Values in a Matrix
 * Attempted
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given an n x n integer matrix grid.
 * <p>
 * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 * <p>
 * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
 * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
 * <p>
 * Return the generated matrix.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * Output: [[9,9],[8,6]]
 * Explanation: The diagram above shows the original matrix and the generated matrix.
 * Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * Output: [[2,2,2],[2,2,2],[2,2,2]]
 * Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 1 <= grid[i][j] <= 100
 */
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 1; i <= n - 2; i++) {
            for (int j = 1; j <= n - 2; j++) {
                res[i - 1][j - 1] = findMax3x3(grid, i, j);
            }
        }
        return res;
    }

    private int findMax3x3(int[][] grid, int startRow, int startCol) {
        int max = Integer.MIN_VALUE;
        for (int i = startRow - 1; i <= startRow + 1; i++) {
            for (int j = startCol - 1; j <= startCol + 1; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.largestLocal(
                new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}}
        ))); // [[9, 9], [8, 6]]
        System.out.println(Arrays.deepToString(solution.largestLocal(
                new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}
        ))); // [[2, 2, 2], [2, 2, 2], [2, 2, 2]]
    }
}