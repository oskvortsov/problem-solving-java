package topic.hash.table;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementFirst {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> greatestMap = new HashMap<>();
        Stack<Integer> greatestStack = new Stack<>();
        int[] result = new int[nums1.length];

        for (int i = nums2.length - 1; i > -1; i--) {
             while (!greatestStack.isEmpty() && greatestStack.peek() < nums2[i]) {
                 greatestStack.pop();
             }

             greatestMap.put(nums2[i], greatestStack.isEmpty() ? -1 : greatestStack.peek());
             greatestStack.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = greatestMap.get(nums1[i]) ;
        }


        return result;
    }
}
