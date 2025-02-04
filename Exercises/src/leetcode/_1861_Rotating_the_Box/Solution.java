package leetcode._1861_Rotating_the_Box;

import java.util.Arrays;

/**
 * 1861. Rotating the Box
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given an m x n matrix of characters boxGrid representing a side-view of a box. Each cell of the box is one of the following:
 * <p>
 * A stone '#'
 * A stationary obstacle '*'
 * Empty '.'
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
 * <p>
 * It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.
 * <p>
 * Return an n x m matrix representing the box after the rotation described above.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: boxGrid = [['#','.','#']]
 * Output: [['.'],
 * ['#'],
 * ['#']]
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: boxGrid = [['#','.','*','.'],
 * ['#','#','*','.']]
 * Output: [['#','.'],
 * ['#','#'],
 * ['*','*'],
 * ['.','.']]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: boxGrid = [['#','#','*','.','*','.'],
 * ['#','#','#','*','.','.'],
 * ['#','#','#','.','#','.']]
 * Output: [['.','#','#'],
 * ['.','#','#'],
 * ['#','#','*'],
 * ['#','*','.'],
 * ['#','.','*'],
 * ['#','.','.']]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == boxGrid.length
 * n == boxGrid[i].length
 * 1 <= m, n <= 500
 * boxGrid[i][j] is either '#', '*', or '.'.
 */
public class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        return shake(rotateCW(boxGrid));
    }

    private char[][] rotateCW(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] newBoxGrid = new char[n][m];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                newBoxGrid[c][m - r - 1] = boxGrid[r][c];
            }
        }
        return newBoxGrid;
    }

    private char[][] shake(char[][] boxGrid) {
        for (int r = boxGrid.length - 2; r >= 0; r--) {
            for (int c = 0; c < boxGrid[0].length; c++) {
                if (boxGrid[r][c] == '#') {
                    int curRow = r;
                    while (curRow < boxGrid.length - 1 && boxGrid[curRow + 1][c] == '.') {
                        boxGrid[curRow + 1][c] = boxGrid[curRow][c];
                        boxGrid[curRow++][c] = '.';
                    }
                }
            }
        }
        return boxGrid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.rotateTheBox(new char[][]
                {{'#', '.', '#'}})));
        // [[.], [#], [#]]

        System.out.println(Arrays.deepToString(solution.rotateTheBox(new char[][]
                {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}})));
        // [[#, .], [#, #], [*, *], [., .]]

        System.out.println(Arrays.deepToString(solution.rotateTheBox(new char[][]
                {{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}})));
        // [[., #, #], [., #, #], [#, #, *], [#, *, .], [#, ., *], [#, ., .]]
    }
}
