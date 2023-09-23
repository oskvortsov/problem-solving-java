package data.structure.stack;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {
    static class Rectangle {
        int index;
        int height;

        Rectangle(int i, int h) {
            index = i;
            height = h;
        }
    }


    public int largestRectangleArea(int[] heights) {
        Stack<Rectangle> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < heights.length; i++) {
            Rectangle cur = new Rectangle(i, heights[i]);

            while (!stack.isEmpty() && stack.peek().height > cur.height) {
                Rectangle prev = stack.pop();
                ans = Math.max(ans, prev.height * (i - prev.index));
                cur.index = prev.index;
            }

            stack.add(cur);
        }

        while (!stack.isEmpty()) {
            Rectangle cur = stack.pop();
            ans = Math.max(ans, cur.height * (heights.length - cur.index));
        }

        return ans;
    }
}
