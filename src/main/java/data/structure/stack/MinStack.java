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
        if (minimal.size() > 0) {
            minimal.push(Math.min(val, getMin()));
        } else {
            minimal.push(val);
        }
    }

    public void pop() {
        original.pop();
        minimal.pop();
    }

    public int top() {
        return original.get(original.size() - 1);
    }

    public int getMin() {
        return minimal.get(minimal.size() - 1);
    }
}
