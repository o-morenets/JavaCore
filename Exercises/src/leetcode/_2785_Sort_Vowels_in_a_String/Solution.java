package leetcode._2785_Sort_Vowels_in_a_String;

import java.util.*;

class Solution {
    public String sortVowels(String s) {
        final Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        List<Character> stringVowels = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                stringVowels.add(s.charAt(i));
            }
        }
        stringVowels.sort(Comparator.naturalOrder());
        StringBuilder res = new StringBuilder();
        char charToAdd;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charToAdd = vowels.contains(currentChar) ? stringVowels.removeFirst() : currentChar;
            res.append(charToAdd);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortVowels("lEetcOde"));
        System.out.println(solution.sortVowels("lYmpH"));
    }
}