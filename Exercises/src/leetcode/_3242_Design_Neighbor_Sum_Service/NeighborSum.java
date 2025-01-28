package leetcode._3242_Design_Neighbor_Sum_Service;

/**
 * 3242. Design Neighbor Sum Service
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given a n x n 2D array grid containing distinct elements in the range [0, n2 - 1].
 * <p>
 * Implement the NeighborSum class:
 * <p>
 * NeighborSum(int [][]grid) initializes the object.
 * int adjacentSum(int value) returns the sum of elements which are adjacent neighbors of value, that is either to the top, left, right, or bottom of value in grid.
 * int diagonalSum(int value) returns the sum of elements which are diagonal neighbors of value, that is either to the top-left, top-right, bottom-left, or bottom-right of value in grid.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * ["NeighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]
 * <p>
 * [[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]
 * <p>
 * Output: [null, 6, 16, 16, 4]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * The adjacent neighbors of 1 are 0, 2, and 4.
 * The adjacent neighbors of 4 are 1, 3, 5, and 7.
 * The diagonal neighbors of 4 are 0, 2, 6, and 8.
 * The diagonal neighbor of 8 is 4.
 * Example 2:
 * <p>
 * Input:
 * <p>
 * ["NeighborSum", "adjacentSum", "diagonalSum"]
 * <p>
 * [[[[1, 2, 0, 3], [4, 7, 15, 6], [8, 9, 10, 11], [12, 13, 14, 5]]], [15], [9]]
 * <p>
 * Output: [null, 23, 45]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * The adjacent neighbors of 15 are 0, 10, 7, and 6.
 * The diagonal neighbors of 9 are 4, 12, 14, and 15.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= n == grid.length == grid[0].length <= 10
 * 0 <= grid[i][j] <= n2 - 1
 * All grid[i][j] are distinct.
 * value in adjacentSum and diagonalSum will be in the range [0, n2 - 1].
 * At most 2 * n2 calls will be made to adjacentSum and diagonalSum.
 */
public class NeighborSum {
    private final int[][] grid;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
    }

    public int adjacentSum(int value) {
        return neighbourSum(value, new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}});
    }

    public int diagonalSum(int value) {
        return neighbourSum(value, new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}});
    }

    private int neighbourSum(int value, int[][] koefs) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == value) {
                    for (int[] pair : koefs) {
                        if (i + pair[0] >= 0 && i + pair[0] < grid.length && j + pair[1] >= 0 && j + pair[1] < grid[0].length) {
                            sum += grid[i + pair[0]][j + pair[1]];
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NeighborSum neighborSum = new NeighborSum(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        System.out.println(neighborSum.adjacentSum(1)); // 6
        System.out.println(neighborSum.adjacentSum(4)); // 16
        System.out.println(neighborSum.diagonalSum(4)); // 16
        System.out.println(neighborSum.diagonalSum(8)); // 4

        neighborSum = new NeighborSum(new int[][]{{1, 2, 0, 3}, {4, 7, 15, 6}, {8, 9, 10, 11}, {12, 13, 14, 5}});
        System.out.println(neighborSum.adjacentSum(15)); // 23
        System.out.println(neighborSum.diagonalSum(9)); // 45
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */