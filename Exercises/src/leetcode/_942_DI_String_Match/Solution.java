package leetcode._942_DI_String_Match;

import java.util.Arrays;

/**
 * 942. DI String Match
 * Solved
 * Easy
 * Topics
 * Companies
 * A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
 *
 * s[i] == 'I' if perm[i] < perm[i + 1], and
 * s[i] == 'D' if perm[i] > perm[i + 1].
 * Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: s = "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: s = "DDI"
 * Output: [3,2,0,1]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either 'I' or 'D'.
 */
public class Solution {
    public int[] diStringMatch(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] perm = new int[n + 1];
        int lo = 0;
        int hi = n;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'D') {
                perm[i] = hi--;
            } else {
                perm[i] = lo++;
            }
        }
        perm[n] = hi;
        return perm;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.diStringMatch("IDID"))); // [0, 4, 1, 3, 2]
        System.out.println(Arrays.toString(solution.diStringMatch("III"))); // [0, 1, 2, 3]
        System.out.println(Arrays.toString(solution.diStringMatch("DDI"))); // [3, 2, 0, 1]
    }
}
