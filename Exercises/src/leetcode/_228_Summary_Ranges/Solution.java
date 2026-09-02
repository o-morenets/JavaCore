package leetcode._228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * You are given a sorted unique integer array nums.
 * <p>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 * <p>
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }

        List<String> ranges = new ArrayList<>();

        int a = 0;
        int b = 1;

        while (a < nums.length) {
            while (b < nums.length && nums[b] - nums[b - 1] == 1) {
                b++;
            }

            if (a == b - 1) {
                ranges.add(String.valueOf(nums[a]));
            } else {
                ranges.add(nums[a] + "->" + nums[b - 1]);
            }

            a = b;
            b++;
        }

        return ranges;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.summaryRanges(new int[]{0, 1, 2, 4, 5, 7})); // ["0->2","4->5","7"]
        System.out.println(s.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})); // ["0","2->4","6","8->9"]
    }
}
