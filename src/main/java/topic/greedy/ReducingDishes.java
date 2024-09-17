package topic.greedy;

import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < satisfaction.length; i++) {
            int temp = 0;
            int index = 1;

            for (int j = i; j < satisfaction.length; j++) {
                temp += satisfaction[j] * index++;
            }

            if (res > temp) {
                break;
            }

            res = temp;
        }


        return Math.max(res, 0);
    }

    public int maxSatisfaction1(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = satisfaction[satisfaction.length - 1];
        int val = satisfaction[satisfaction.length - 1];
        int max = val;

        for (int i = satisfaction.length - 2; i >= 0; i--) {
            sum += satisfaction[i];
            val += sum;

            if (max < val) {
                break;
            }

            max = val;
        }

        return max;
    }
}
