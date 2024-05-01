package jat;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateParenthesis(n);
        System.out.println(combinations);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, n, result);
        return result;
    }

    private static void generate(String current, int openCount, int closeCount, List<String> result) {
        if (openCount == 0 && closeCount == 0) {
            result.add(current);
            return;
        }

        if (openCount > 0) {
            generate(current + "(", openCount - 1, closeCount, result);
        }

        if (closeCount > openCount) {
            generate(current + ")", openCount, closeCount - 1, result);
        }
    }
}
