package topic.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        var counter = new int[candidates.length];

        process(0, candidates, target, counter, result);

        return result;
    }

    private void process(int l, int[] candidates, int target, int[] counter, List<List<Integer>> result) {
        if (target == 0) addCombinations(candidates, counter, result);
        if (target <= 0 || l >= candidates.length) return;

        for (int i = l; i < candidates.length; i++) {
            counter[i]++;
            process(i, candidates, target - candidates[i], counter, result);
            counter[i]--;
        }
    }

    private void addCombinations(int[] candidates, int[] counter, List<List<Integer>> result) {
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < counter.length; i++) {
            int times = counter[i];

            while (times > 0) {
                tmp.add(candidates[i]);
                times--;
            }
        }

        result.add(tmp);
    }
}
