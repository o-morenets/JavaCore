package leetcode._1314_Matrix_Block_Sum;

import java.util.Arrays;

/**
 * 1314. Matrix Block Sum
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k, and
 * (r, c) is a valid position in the matrix.
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 * Example 2:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, k <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                answer[r][c] = calcBlock(mat, r, c, k);
            }
        }
        return answer;
    }

    private int calcBlock(int[][] mat, int r, int c, int k) {
        int sum = 0;
        for (int i = r; i < r + 2 * k + 1; i++) {
            for (int j = c; j < c + 2 * k + 1; j++) {
                if (isValidIndex(mat, i - k, j - k)) {
                    sum += mat[i - k][j - k];
                }
            }
        }
        return sum;
    }

    private boolean isValidIndex(int[][] mat, int r, int c) {
        return r >= 0 && r < mat.length && c >= 0 && c < mat[0].length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(solution.matrixBlockSum(mat, 1))); // [[12, 21, 16], [27, 45, 33], [24, 39, 28]]
        System.out.println(Arrays.deepToString(solution.matrixBlockSum(mat, 2))); // [[45, 45, 45], [45, 45, 45], [45, 45, 45]]
    }
}
