package data.structure.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    class KthLargest {
        private PriorityQueue<Integer> data;
        private int capacity;

        public KthLargest(int k, int[] nums) {
           data = new PriorityQueue<>((a,b) -> a - b);
           capacity = k;

           for (int n: nums) {
               data.add(n);

               if (data.size() > k) {
                   data.poll();
               }
           }
        }

        public int add(int val) {
            data.add(val);

            if (data.size() > capacity) {
                data.poll();
            }

            return data.peek();
        }
    }

    KthLargest create(int k, int[] nums) {
        return new KthLargest(k, nums);
    }
}
