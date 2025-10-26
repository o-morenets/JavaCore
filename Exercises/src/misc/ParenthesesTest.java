package misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesTest {

    @Test
    void isBalanced_emptyString_returnsTrue() {
        assertTrue(Parentheses.isBalanced(""));
    }

    @Test
    void isBalanced_valid_returnsTrue() {
        assertTrue(Parentheses.isBalanced("((()))"));
    }

    @Test
    void isBalanced_invalidOrder_returnsFalse() {
        assertFalse(Parentheses.isBalanced(")("));
    }

    @Test
    void isBalanced_unbalanced_returnsFalse() {
        assertFalse(Parentheses.isBalanced("(())()("));
    }

    @Test
    void isBalanced_oddNumberOfCharacters_returnsFalse() {
        assertFalse(Parentheses.isBalanced("((())))"));
    }
}