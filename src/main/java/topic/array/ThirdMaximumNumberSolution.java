package topic.array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ThirdMaximumNumberSolution {
    public int thirdMaxMinHeap(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> taken = new HashSet<>();

        for (int num: nums) {
            if (taken.contains(num)) continue;
            if (taken.size() == 3) {
                if (pq.peek() < num) {
                    taken.remove(pq.poll());

                    taken.add(num);
                    pq.add(num);
                }
            } else {
                taken.add(num);
                pq.add(num);
            }
        }

        if (pq.size() == 1) return pq.peek();
        if (pq.size() == 2) return Math.max(pq.poll(), pq.peek());

        return pq.peek();
    }

    public int thirdMaxSortSet(int[] nums) {
        TreeSet<Integer> sortNums = new TreeSet<>();

        for (int num: nums) {
            if (sortNums.contains(num)) continue;

            if (sortNums.size() == 3) {
                if (sortNums.first() < num) {
                    sortNums.pollFirst();
                    sortNums.add(num);
                }
            } else {
                sortNums.add(num);
            }
        }

        if (sortNums.size() == 3) return sortNums.first();

        return sortNums.last();
    }
 }
