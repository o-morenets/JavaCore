package misc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxStackTest {

    private static MaxStack maxStack;

    @BeforeEach
    void setUpBeforeClass() throws Exception {
        maxStack = new MaxStack();
    }

    @Test
    void push_shouldPopTheSame() {
        maxStack.push(987);
        assertEquals(987, maxStack.pop());
    }

    @Test
    void pop_whenEmptyStack_returnsNull() {
        assertNull(maxStack.pop());
    }

    @Test
    void pop_whenStackWithOneElement_returnsElement() {
        maxStack.push(10);
        assertEquals(10, maxStack.pop());
    }

    @Test
    void max_whenEmptyStack_returnsNull() {
        assertNull(maxStack.max());
    }

    @Test
    void max_whenStackWithOneElement_returnsElement() {
        maxStack.push(10);
        assertEquals(10, maxStack.max());
    }

    @Test
    void max_whenStackWithMultipleElements_returnsMaxElement() {
        maxStack.push(30);
        maxStack.push(10);
        maxStack.push(50);
        maxStack.push(40);
        maxStack.push(20);
        assertEquals(50, maxStack.max());
    }
}