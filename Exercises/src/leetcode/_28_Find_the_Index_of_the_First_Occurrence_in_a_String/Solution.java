package leetcode._28_Find_the_Index_of_the_First_Occurrence_in_a_String;

/**
 * 28. Find the Index of the First Occurrence in a String
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length())
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solutions = new Solution();

        System.out.println(solutions.strStr("sadbutsad", "sad"));  // 0
        System.out.println(solutions.strStr("leetcode", "leeto")); // -1
    }
}
