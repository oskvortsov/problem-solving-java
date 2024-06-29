package data.structure.stack;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
public class QueueByStack {
    private final Stack<Integer> writeStack;

    QueueByStack() {
        writeStack = new Stack<>();
    }

    // Only Push take O(n) time
    public void push(int x) {
        Stack<Integer> bufferStack = new Stack<>();

        while (!writeStack.isEmpty()) {
            bufferStack.push(writeStack.pop());
        }

        writeStack.push(x);

        while (!bufferStack.isEmpty()) {
            writeStack.push(bufferStack.pop());
        }
    }

    public int pop() {
        return writeStack.pop();
    }

    public int peek() {
       return writeStack.peek();
    }

    public boolean empty() {
        return writeStack.isEmpty();
    }

//    Pop and Push take O(n) time
//    public void push(int x) {
//        writeStack.push(x);
//    }
//
//    public int pop() {
//        if (writeStack.isEmpty()) return -1;
//
//        Stack<Integer> bufferStack = new Stack<>();
//
//        while (!writeStack.isEmpty()) {
//            bufferStack.push(writeStack.pop());
//        }
//
//        int val = bufferStack.pop();
//
//        while (!bufferStack.isEmpty()) {
//            writeStack.push(bufferStack.pop());
//        }
//
//        return val;
//    }
//
//    public int peek() {
//        if (writeStack.isEmpty()) return -1;
//
//        Stack<Integer> bufferStack = new Stack<>();
//
//        while (!writeStack.isEmpty()) {
//            bufferStack.push(writeStack.pop());
//        }
//
//        int val = bufferStack.peek();
//
//        while (!bufferStack.isEmpty()) {
//            writeStack.push(bufferStack.pop());
//        }
//
//        return val;
//    }
//
//    public boolean empty() {
//        return writeStack.isEmpty();
//    }
}
