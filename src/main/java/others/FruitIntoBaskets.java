package others;

import java.util.*;

// 2,1,3,2,2
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        Set<Integer> cur = new HashSet<>();
        int max = 1;
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {
            cur.add(fruits[right]);

            if (cur.size() > 2) {
                left = right - 1;

                while (left > 0 && fruits[left - 1] == fruits[left]) {
                    left--;
                }
                cur.remove(fruits[left - 1]);
            }

            max = Math.max(right - left + 1, max);
        }

        return max;
    }
}
