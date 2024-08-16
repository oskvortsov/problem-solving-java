package data.structure.heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/last-stone-weight/description/

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stone: stones) pq.add(stone);

        System.out.println(pq.toArray());
        while (pq.size() > 1) {
            int newStone = Math.abs(pq.poll() - pq.poll());
            if (newStone != 0) pq.add(newStone);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
