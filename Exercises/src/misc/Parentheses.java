package misc;

public class Parentheses {

    void main() {
        System.out.println(isBalanced("")); // true
        System.out.println(isBalanced("(())()(")); // false
        System.out.println(isBalanced("((()))")); // true
        System.out.println(isBalanced(")(")); // false
        System.out.println(isBalanced("(())(()(())())")); // true
        System.out.println(isBalanced("((())))")); // false
    }

    static boolean isBalanced(String str) {
//        Deque<Character> stack = new ArrayDeque<>();

        // early return when odd number of parentheses
        if (str == null || str.length() % 2 != 0) {
            return false;
        }

        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
//                stack.push(c);
                counter++;
            } else if (c == ')') {
//                if (stack.isEmpty()) {
                if (counter == 0) {
                    return false;
                }
//                stack.pop();
                counter--;
            }

            // early return when more opening parentheses than closing ones
            if (counter > str.length() / 2) {
                return false;
            }
        }

//        return stack.isEmpty();
        return counter == 0;
    }
}