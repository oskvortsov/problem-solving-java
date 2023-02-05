package data.structure.stack;

import java.util.Stack;

public class DailyTemperatures {
    // [73,74,75,71,69,72,76,73]
    // [1,1,4,2,1,1,0,0]
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> waitList = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int cur = temperatures[i];

            while(!waitList.isEmpty() && temperatures[waitList.peek()] < cur) {
                res[waitList.peek()] = i - waitList.pop();
            }

            waitList.push(i);
        }


        return res;
    }
}
