package leetcode._225_Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * Attempted
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * <p>
 * Implement the MyStack class:
 * <p>
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 * <p>
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * <p>
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 */
public class MyStack {
    private final Queue<Integer> q1;
    private final Queue<Integer> q2;
    private Queue<Integer> q;
    private Queue<Integer> emptyQ;

    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        q = q1;
        emptyQ = q2;
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            emptyQ.add(q.remove());
        }
        int last = q.remove();
        swap();

        return last;
    }

    public int top() {
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            emptyQ.add(q.remove());
        }
        int last = q.remove();
        emptyQ.add(last);
        swap();

        return last;
    }

    public boolean empty() {
        return q.isEmpty();
    }

    private void swap() {
        if (q1.isEmpty()) {
            emptyQ = q1;
            q = q2;
        } else {
            emptyQ = q2;
            q = q1;
        }
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int pop = obj.pop();
        System.out.println("pop = " + pop);
        int top = obj.top();
        System.out.println("top = " + top);
        boolean empty = obj.empty();
        System.out.println("empty = " + empty);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */