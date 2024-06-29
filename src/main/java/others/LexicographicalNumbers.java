package others;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/lexicographical-numbers/description/
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        traverser(1, n, result);

        return result;
    }

    public void traverser(int current, int n, List<Integer> list) {
        if (current > n) return;

        for (int i = current; i < current + 10; i++) {
            if (list.size() == n) return;

            if (i <= n) {
                list.add(i);
                traverser(i * 10, n, list);
            }
        }
    }
}
