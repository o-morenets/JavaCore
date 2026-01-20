package leetcode._2000_Reverse_Prefix_of_Word;

/**
 * 2000. Reverse Prefix of Word
 * Easy
 * Topics
 * Companies
 * Hint
 * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
 *
 * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
 * Return the resulting string.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "abcdefd", ch = "d"
 * Output: "dcbaefd"
 * Explanation: The first occurrence of "d" is at index 3.
 * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
 * Example 2:
 *
 * Input: word = "xyxzxe", ch = "z"
 * Output: "zxyxxe"
 * Explanation: The first and only occurrence of "z" is at index 3.
 * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
 * Example 3:
 *
 * Input: word = "abcd", ch = "z"
 * Output: "abcd"
 * Explanation: "z" does not exist in word.
 * You should not do any reverse operation, the resulting string is "abcd".
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 250
 * word consists of lowercase English letters.
 * ch is a lowercase English letter.
 */
class Solution {

    public String reversePrefix(String word, char ch) {
        String reversedPart = "";
        String lastPart = word;
        int i;
        for (i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                break;
            }
        }
        if (i < word.length()) {
            reversedPart = reverseString(word.substring(0, i + 1));
            lastPart = word.substring(i + 1);
        }
        return reversedPart + lastPart;
    }

    private String reverseString(String word) {
        if (word.isEmpty()) {
            return "";
        }
        return word.charAt(word.length() - 1) + reverseString(word.substring(0, word.length() - 1));
    }

    public String reversePrefix1(String word, char ch) {
        var sb = new StringBuilder();
        char current = 0;

        for (int i = 0; i < word.length(); i++) {
            current = word.charAt(i);
            sb.insert(0, current);
            if (current == ch) {
                break;
            }
        }

        if (word.length() == sb.length() && current != ch) return word;

        sb.append(word.substring(sb.length()));

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reversePrefix("abcdefd", 'd')); // "dcbaefd"
        System.out.println(solution.reversePrefix("xyxzxe", 'z')); // "zxyxxe"
        System.out.println(solution.reversePrefix("abcd", 'z')); // "abcd"
        System.out.println(solution.reversePrefix("rzwuktxcjfpamlonbgyieqdvhs", 's')); // "shvdqeiygbnolmapfjcxtkuwzr"

        System.out.println(solution.reversePrefix1("abcdefd", 'd')); // "dcbaefd"
        System.out.println(solution.reversePrefix1("xyxzxe", 'z')); // "zxyxxe"
        System.out.println(solution.reversePrefix1("abcd", 'z')); // "abcd"
        System.out.println(solution.reversePrefix1("rzwuktxcjfpamlonbgyieqdvhs", 's')); // "shvdqeiygbnolmapfjcxtkuwzr"
    }
}