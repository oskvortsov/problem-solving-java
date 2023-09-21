package topic.array;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        return topKFrequentBuffer(nums, k);
    }

    public int[] topKFrequentPQ(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num: nums) frequency.put(num, frequency.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(frequency::get));
        for (int key: frequency.keySet()) {
            pq.offer(key);

            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[pq.size()];
        int index = 0;
        while (!pq.isEmpty()) ans[index++] = pq.poll();

        return ans;
    }

    public int[] topKFrequentBuffer(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // we need size between min and max element
        int[] frequency = new int[max - min + 1];
        int maxFrequency = 0;
        for (int num: nums) {
            // count elements and found the most frequent element
            maxFrequency = Math.max(maxFrequency, ++frequency[num - min]);
        }

        // group element by frequency
        List<Integer>[] buffer = new ArrayList[maxFrequency + 1];
        for (int i = 0; i < frequency.length; i++) {
            int f = frequency[i];
            if (f <= 0) continue;

            if (buffer[f] == null) buffer[f] = new ArrayList<>();
            buffer[f].add(i + min);
        }

        int[] ans = new int[k];

        // fill answers from most frequent element
        int i = 0;
        for (int j = maxFrequency; j >= 0 && i < k; j--) {
            if (buffer[j] == null) continue;
            for (int n: buffer[j]) ans[i++] = n;
        }

        return ans;
    }
}
