package leetcode._155_MinStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> mins;

    public MinStack() {
        stack = new ArrayDeque<>();
        mins = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);
        if (mins.isEmpty() || value <= mins.peekFirst()) {
            mins.push(value);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (Objects.equals(stack.peekFirst(), mins.peekFirst())) {
            mins.pop();
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public int getMin() {
        if (mins.isEmpty()) {
            return -1;
        }
        return mins.peekFirst();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

// 1. Порожній стек
        System.out.println(s.top());     // -1
        System.out.println(s.getMin());  // -1
        s.pop();                         // нічого не повинно статися


// 2. Один елемент
        s.push(5);

        System.out.println(s.top());     // 5
        System.out.println(s.getMin());  // 5

        s.pop();

        System.out.println(s.top());     // -1
        System.out.println(s.getMin());  // -1


// 3. Звичайна послідовність
        s.push(5);
        s.push(3);
        s.push(7);

        System.out.println(s.getMin());  // 3
        System.out.println(s.top());     // 7

        s.pop();

        System.out.println(s.top());     // 3
        System.out.println(s.getMin());  // 3

        s.pop();

        System.out.println(s.top());     // 5
        System.out.println(s.getMin());  // 5


// 4. Новий мінімум
        s.push(10);
        s.push(5);
        s.push(3);
        s.push(1);

        System.out.println(s.getMin());  // 1

        s.pop();

        System.out.println(s.getMin());  // 3

        s.pop();

        System.out.println(s.getMin());  // 5

        s.pop();

        System.out.println(s.getMin());  // 5


// 5. Дублікати мінімуму
        s = new MinStack();

        s.push(5);
        s.push(3);
        s.push(3);
        s.push(7);

        System.out.println(s.getMin());  // 3

        s.pop(); // 7

        System.out.println(s.getMin());  // 3

        s.pop(); // 3

        System.out.println(s.getMin());  // 3

        s.pop(); // 3

        System.out.println(s.getMin());  // 5


// 6. Дублікати одного й того самого значення
        s = new MinStack();

        s.push(2);
        s.push(2);
        s.push(2);

        System.out.println(s.getMin());  // 2

        s.pop();
        System.out.println(s.getMin());  // 2

        s.pop();
        System.out.println(s.getMin());  // 2

        s.pop();
        System.out.println(s.getMin());  // -1


// 7. Мінімум повертається назад після pop()
        s = new MinStack();

        s.push(5);
        s.push(3);
        s.push(1);
        s.push(4);

        System.out.println(s.getMin());  // 1

        s.pop(); // 4
        System.out.println(s.getMin());  // 1

        s.pop(); // 1
        System.out.println(s.getMin());  // 3

        s.pop(); // 3
        System.out.println(s.getMin());  // 5


// 8. Від'ємні числа
        s = new MinStack();

        s.push(-1);
        s.push(-5);
        s.push(-3);
        s.push(-10);

        System.out.println(s.getMin());  // -10

        s.pop();

        System.out.println(s.getMin());  // -5

        s.pop();

        System.out.println(s.getMin());  // -5


// 9. Чергування push/pop
        s = new MinStack();

        s.push(10);
        System.out.println(s.getMin());  // 10

        s.push(5);
        System.out.println(s.getMin());  // 5

        s.pop();
        System.out.println(s.getMin());  // 10

        s.push(2);
        System.out.println(s.getMin());  // 2

        s.pop();
        System.out.println(s.getMin());  // 10


// 10. Integer cache boundary / перевірка ==
        s = new MinStack();

        s.push(1000);
        s.push(2000);
        s.push(1000);

        System.out.println(s.getMin());  // 1000

        s.pop();

        System.out.println(s.getMin());  // 1000

        s.pop();

        System.out.println(s.getMin());  // 1000


// 11. MAX_VALUE / MIN_VALUE
        s = new MinStack();

        s.push(Integer.MAX_VALUE);
        s.push(Integer.MIN_VALUE);

        System.out.println(s.getMin());  // Integer.MIN_VALUE

        s.pop();

        System.out.println(s.getMin());  // Integer.MAX_VALUE
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */