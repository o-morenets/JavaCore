package leetcode._1351_Count_Negative_Numbers_in_a_Sorted_Matrix;

/**
 * 1351. Count Negative Numbers in a Sorted Matrix
 * Easy
 * Topics
 * Companies
 * Hint
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 *
 * Follow up: Could you find an O(n + m) solution?
 */
public class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int leftIndex = 0;
        int count = 0;
        for (int r = m - 1; r >= 0; r--) {
            if (grid[r][n - 1] < 0) {
                leftIndex = findMinNegativeIndexInRow(grid[r], leftIndex);
                count += n - leftIndex;
            }
        }
        return count;
    }

    private int findMinNegativeIndexInRow(int[] gridRow, int startIndex) {
        int leftIdx = startIndex;
        int rightIdx = gridRow.length;

        while (leftIdx <= rightIdx) {
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
            if (gridRow[midIdx] < 0) {
                rightIdx = midIdx - 1;
            } else {
                leftIdx = midIdx + 1;
            }
        }
        return leftIdx;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}})); // 8
        System.out.println(solution.countNegatives(new int[][]{{3, 2}, {1, 0}})); // 0
    }
}
