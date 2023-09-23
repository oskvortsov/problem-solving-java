package data.structure.stack;

import java.util.Stack;

class MinStack {
    private final Stack<Integer> original;
    private final Stack<Integer> minimal;

    public MinStack() {
        original = new Stack<>();
        minimal = new Stack<>();
    }

    public void push(int val) {
        original.push(val);

        int min = minimal.isEmpty() || minimal.peek() > val ? val : minimal.peek();
        minimal.push(min);
    }

    public void pop() {
        minimal.pop();
        original.pop();
    }

    public int top() {
        return original.peek();
    }

    public int getMin() {
        return minimal.peek();
    }
}
