package topic.array;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/rank-transform-of-an-array/
public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;
        rankMap.put(sortedArr[0], rank);

        for (int i = 1; i < sortedArr.length; i++) {
            if (sortedArr[i] > sortedArr[i - 1]) {
                rankMap.put(sortedArr[i], ++rank);
            }
        }

        for (int i = 0; i < arr.length; i++) arr[i] = rankMap.get(arr[i]);

        return arr;
    }
}
