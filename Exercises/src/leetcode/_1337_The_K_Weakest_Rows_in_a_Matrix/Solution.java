package leetcode._1337_The_K_Weakest_Rows_in_a_Matrix;

import java.util.*;

/**
 * 1337. The K Weakest Rows in a Matrix
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
 * <p>
 * A row i is weaker than a row j if one of the following is true:
 * <p>
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * Example 2:
 * <p>
 * Input: mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 */
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        Map<Long, List<Integer>> soldierIndexes = new TreeMap<>();
        for (int i = 0; i < mat.length; i++) {
            long numSoldiers = Arrays.stream(mat[i]).filter(x -> x == 1).count();
            List<Integer> indexes = soldierIndexes.get(numSoldiers);
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            soldierIndexes.put(numSoldiers, indexes);
        }
        Iterator<Map.Entry<Long, List<Integer>>> itr = soldierIndexes.entrySet().iterator();
        int counter = 0;
        while (itr.hasNext() && counter <= k - 1) {
            List<Integer> indexes = itr.next().getValue();
            for (int idx : indexes) {
                if (counter == k) {
                    break;
                }
                res[counter++] = idx;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.kWeakestRows(new int[][]
                        {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}}, 3))); // [2, 0, 3]
        System.out.println(Arrays.toString(solution.kWeakestRows(new int[][]
                        {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}}, 2))); // [0, 2]
    }
}
