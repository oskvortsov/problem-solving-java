package data.structure.heap;

import java.util.PriorityQueue;
import java.util.Random;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int kLargestIndex = nums.length - k;
        int l = 0, r = nums.length - 1;
        Random rand = new Random();

        while (true) {
            int pivotIndex = l + rand.nextInt(r - l + 1);

            pivotIndex = partition(nums, l, r, pivotIndex);

            if (pivotIndex == kLargestIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < kLargestIndex) {
                l = pivotIndex + 1;
            } else {
                r = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        int i = left;

        swap(nums, pivotIndex, right);

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);

        return i;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else if (pq.peek() < num) {
                    pq.poll();
                    pq.add(num);
            }
        }

        return pq.peek();
    }
}
