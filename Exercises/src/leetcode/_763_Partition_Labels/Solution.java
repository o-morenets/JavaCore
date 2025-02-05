package leetcode._763_Partition_Labels;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();

        int[] lastIndexes = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndexes[chars[i] - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < chars.length; i++) {
            int lastIdx = lastIndexes[chars[i] - 'a'];
            if (i >= start && i <= end) {
                if (lastIdx > end) {
                    end = lastIdx;
                }
            } else {
                result.add(end - start + 1);
                start = i;
                end = lastIdx;
            }
        }

        result.add(end - start + 1);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij")); // [9, 7, 8]
        System.out.println(solution.partitionLabels("eccbbbbdec")); // [10]
    }
}
