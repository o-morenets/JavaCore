package misc;

public class Brackets {

    public static void main(String[] args) {
        System.out.println(countPossibilities("[."));
        System.out.println(countPossibilities("...")); // 0 (as the input string contains odd number of characters, there is no solution)
        System.out.println(countPossibilities("....[.[.")); // 2 (as the proper expressions are "[][][][]" and "[[]][][]")
    }

    public static int countPossibilities(String input) {
        return brackets(input, 0, 0);
    }

    public static int brackets(String pattern, int index, int toClose) {
        int count = 0;
        if (toClose >= 0) {
            count = 1;
            if (toClose == 0) {
                if (index == pattern.length() || toClose > pattern.length() - index) {
                    count += brackets(pattern, index + 1, toClose + 1);
                }
            }
        } else {
            if (pattern.charAt(index) != '[') { ////////////////////////////////////////////////////////////////////////////
                count += brackets(pattern, index + 1, toClose - 1);
            }
        }
        return count;
    }
}
