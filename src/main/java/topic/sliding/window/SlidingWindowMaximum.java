package topic.sliding.window;

import java.util.*;

class WindowQueue {
    private final Deque<int[]> queue;
    private final int k;

    WindowQueue(int k) {
        this.k = k;
        this.queue = new ArrayDeque<>();
    }

    void push(int index, int val) {
        clearHead(index);
        pushTail(index, val);
    }

    int getMax() {
        return queue.peekFirst()[1];
    }

    private void clearHead(int index) {
        while (!queue.isEmpty() && index - queue.peek()[0] >= k) {
            this.queue.removeFirst();
        }
    }

    private void pushTail(int index, int val) {
        while (!queue.isEmpty() && queue.peekLast()[1] < val) {
            queue.removeLast();
        }
        queue.addLast(new int[] { index, val });
    }
}

// https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.removeLast();
            dq.addLast(i);

            if (dq.peekFirst() <= i - k) dq.removeFirst();
            if (i - k + 1 >= 0) result[i - k + 1] = nums[dq.peekFirst()];
        }

        return result;
    }

    public int[] maxSlidingWindowWQ(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        WindowQueue wq = new WindowQueue(k);
        for (int i = 0; i < k; i++) wq.push(i, nums[i]);

        for (int i = 0; i < result.length; i++) {
            result[i] = wq.getMax();
            if (i + k < nums.length) wq.push(i + k, nums[i + k]);
        }

        return result;
    }

    // exception TLE
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int maxIndex = getMaxIndex(nums, 0, k);
        int window = k - 1;

        // 1,3,-1,-3,5,3,6,7
        // maxIndex = 1
        for (int i = 0; i < result.length; i++) {
            int numIndex = i + window;

            if (nums[maxIndex] < nums[numIndex]) {
                maxIndex = numIndex;
            } else if ((numIndex - window) > maxIndex) {
                maxIndex = getMaxIndex(nums, numIndex - window, numIndex + 1);
            }

            result[i] = nums[maxIndex];
        }

        return result;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        int max = start;

        for (int i = start; i < end; i++) {
            if (nums[i] > nums[max]) max = i;
        }

        return max;
    }

    // PQ exception TLE
    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) pq.add(nums[i]);

        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.peek();

            if (i + k < nums.length) {
                pq.remove(nums[i]);
                pq.add(nums[i + k]);
            }
        }

        return ans;
    }
}
