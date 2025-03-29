package leetcode._3280_Convert_Date_to_Binary;

/**
 * 3280. Convert Date to Binary
 * Solved
 * Easy
 * Topics
 * Companies
 * You are given a string date representing a Gregorian calendar date in the yyyy-mm-dd format.
 *
 * date can be written in its binary representation obtained by converting year, month, and day to their binary representations without any leading zeroes and writing them down in year-month-day format.
 *
 * Return the binary representation of date.
 *
 *
 *
 * Example 1:
 *
 * Input: date = "2080-02-29"
 *
 * Output: "100000100000-10-11101"
 *
 * Explanation:
 *
 * 100000100000, 10, and 11101 are the binary representations of 2080, 02, and 29 respectively.
 *
 * Example 2:
 *
 * Input: date = "1900-01-01"
 *
 * Output: "11101101100-1-1"
 *
 * Explanation:
 *
 * 11101101100, 1, and 1 are the binary representations of 1900, 1, and 1 respectively.
 *
 *
 *
 * Constraints:
 *
 * date.length == 10
 * date[4] == date[7] == '-', and all other date[i]'s are digits.
 * The input is generated such that date represents a valid Gregorian calendar date between Jan 1st, 1900 and Dec 31st, 2100 (both inclusive).
 */
class Solution {
    public String convertDateToBinary(String date) {
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        String yearBin = Integer.toBinaryString(year);
        String monthBin = Integer.toBinaryString(month);
        String dayBin = Integer.toBinaryString(day);

        return yearBin + "-" + monthBin + "-" + dayBin;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertDateToBinary("2080-02-29")); // 100000100000-10-11101
        System.out.println(solution.convertDateToBinary("1900-01-01")); // 11101101100-1-1
    }
}