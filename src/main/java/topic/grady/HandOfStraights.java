package topic.grady;

import java.util.ArrayList;
import java.util.HashMap;

// https://leetcode.com/problems/hand-of-straights/description/
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int card: hand) {
            frequency.put(card, frequency.getOrDefault(card, 0) + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(frequency.keySet());
        keys.sort(Integer::compareTo);

        for (int key: keys) {
            if (frequency.get(key) > 0) {
                int countKey = frequency.get(key);

                for (int i = key; i < key + groupSize; i++) {
                    if (frequency.getOrDefault(i, 0) < countKey) {
                        return false;
                    }

                    frequency.put(i, frequency.get(i) - countKey);
                }
            }
        }

        return true;
    }

    public boolean isNStraightHand1(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int card: hand) {
            frequency.put(card, frequency.getOrDefault(card, 0) + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(frequency.keySet());
        keys.sort(Integer::compareTo);

        while (!frequency.isEmpty()) {
            int prev = -1;

            if (keys.size() < groupSize) return false;

            for (int i = 0; i < groupSize; i++) {
                int key = keys.get(i);

                if (prev != -1 && key - prev > 1) return false;
                prev = key;
                frequency.put(key, frequency.get(key) - 1);
            }

            clearFrequency(frequency, keys, groupSize);
        }

        return keys.size() == 0;
    }

    private void clearFrequency(HashMap<Integer, Integer> frequency, ArrayList<Integer> keys, int groupSize) {
        int index = 0;

        for (int i = 0; i < groupSize; i++) {
            int key = keys.get(index);

            if (!frequency.containsKey(key) || frequency.get(key) == 0) {
                frequency.remove(key);
                keys.remove(index);
            } else {
                index++;
            }
         }
    }
}
