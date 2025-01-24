package leetcode._3211_Generate_Binary_Strings_Without_Adjacent_Zeros;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return List.of();
        }

        generateValidStrings(result, n - 1, "0");
        generateValidStrings(result, n - 1, "1");

        return result;
    }

    private void generateValidStrings(List<String> resultList, int n, String s) {
        if (n == 0) {
            resultList.add(s);
            return;
        }

        generateValidStrings(resultList, n - 1, s + "1");

        if (s.isEmpty() || s.charAt(s.length() - 1) != '0') {
            generateValidStrings(resultList, n - 1, s + "0");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validStrings(0)); // []
        System.out.println(solution.validStrings(1)); // [0, 1]
        System.out.println(solution.validStrings(2)); // [01, 11, 10]
        System.out.println(solution.validStrings(3)); // [011, 010, 111, 110, 101]
    }
}