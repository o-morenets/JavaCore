package leetcode._27_remove_element;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {1};
//        int val = 1;
        int[] nums = {3, 2, 2, 3};
        int val = 3;
//        int[] nums = {3, 3};
//        int val = 3;

        int k = new Solution().removeElement(nums, val);
        System.out.println("k = " + k);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int num : nums) {
            if (num != val) {
                nums[k++] = num;
            }
        }
        return k;
    }
}
