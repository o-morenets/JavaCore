package misc;

import java.util.Stack;

public class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public MaxStack() {
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (maxStack.isEmpty() || maxStack.peek() < value) {
            maxStack.push(value);
        }
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        } else {
            int value = stack.pop();
            if (maxStack.peek() == value) {
                maxStack.pop();
            }
            return value;
        }
    }

    public Integer max() {
        if (maxStack.isEmpty()) {
            return null;
        }
        return maxStack.peek();
    }
}
