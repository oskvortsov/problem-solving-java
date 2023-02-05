package data.structure.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> nums.push(nums.pop() + nums.pop());
                case "-" -> {
                    int second = nums.pop();
                    int first = nums.pop();
                    nums.push(first - second);
                }
                case "*" -> nums.push(nums.pop() * nums.pop());
                case "/" -> {
                    int second = nums.pop();
                    int first = nums.pop();
                    nums.push(first / second);
                }
                default -> nums.push(Integer.parseInt(token));
            }
        }

        return nums.peek();
    }
}
