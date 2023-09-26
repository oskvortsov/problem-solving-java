package topic.two.points;

public class TwoSumTwoInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] ans = new int[2];

        while (l < r) {
            int cur = numbers[l] + numbers[r];

            if (cur == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            }

            if (cur > target) r--;
            else l++;
        }

        return ans;
    }
}
