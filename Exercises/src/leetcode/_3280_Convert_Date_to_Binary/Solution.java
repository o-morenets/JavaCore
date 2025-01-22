package leetcode._3280_Convert_Date_to_Binary;

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
        System.out.println(new Solution().convertDateToBinary("2020-1-1"));
    }
}