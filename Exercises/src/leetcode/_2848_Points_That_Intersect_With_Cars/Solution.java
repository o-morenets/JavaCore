package leetcode._2848_Points_That_Intersect_With_Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2848. Points That Intersect With Cars
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given a 0-indexed 2D integer array nums representing the coordinates of the cars parking on a number line. For any index i, nums[i] = [starti, endi] where starti is the starting point of the ith car and endi is the ending point of the ith car.
 * <p>
 * Return the number of integer points on the line that are covered with any part of a car.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [[3,6],[1,5],[4,7]]
 * Output: 7
 * Explanation: All the points from 1 to 7 intersect at least one car, therefore the answer would be 7.
 * Example 2:
 * <p>
 * Input: nums = [[1,3],[5,8]]
 * Output: 7
 * Explanation: Points intersecting at least one car are 1, 2, 3, 5, 6, 7, 8. There are a total of 7 points, therefore the answer would be 7.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * nums[i].length == 2
 * 1 <= starti <= endi <= 100
 */
public class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        List<int[]> numList = nums.stream()
                .map(r -> new int[]{r.getFirst(), r.getLast()})
                .sorted(Comparator.comparingInt(arr -> arr[0]))
                .toList();

        int length = 0;
        int prevEnd = 0;
        for (int[] range : numList) {
            int currentLength = range[1] - range[0] + 1;
            if (range[0] > prevEnd) {
                length += currentLength;
                prevEnd = range[1];
            } else if (range[1] > prevEnd) {
                length += range[1] - prevEnd;
                prevEnd = range[1];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> nums = new ArrayList<>();
//        nums.add(Arrays.asList(3, 6));
//        nums.add(Arrays.asList(1, 5));
//        nums.add(Arrays.asList(4, 7));
//        System.out.println(solution.numberOfPoints(nums)); // Output: 7

//        nums.clear();
//        nums.add(Arrays.asList(1, 3));
//        nums.add(Arrays.asList(5, 8));
//        System.out.println(solution.numberOfPoints(nums)); // Output: 7

        nums.clear();
        nums.add(Arrays.asList(2, 5));
        nums.add(Arrays.asList(3, 8));
        nums.add(Arrays.asList(1, 6));
        nums.add(Arrays.asList(4, 10));
        System.out.println(solution.numberOfPoints(nums)); // Output: 7
    }
}
