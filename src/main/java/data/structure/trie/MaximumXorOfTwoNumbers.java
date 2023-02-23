package data.structure.trie;

import java.util.ArrayList;
import java.util.HashMap;

//https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1057/
public class MaximumXorOfTwoNumbers {
    public int findMaximumXOR(int[] nums) {
        int[] count = new int[32];
        HashMap<Integer, ArrayList<Integer>> bitMap = new HashMap<>();

        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                int mask = 1 << i - 1;

                if ((num & mask) != 0) {
                    count[i]++;
                    ArrayList<Integer> list = bitMap.getOrDefault(i, new ArrayList<>());
                    list.add(num);
                    bitMap.put(i, list);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 32; i++) {
            if (count[i] == 1) {
                list.addAll(bitMap.get(i));
            }
        }

        int max = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size(); j++) {
                max = Math.max(list.get(i) ^ list.get(j), max);
            }
        }

        return max;
    }
}
