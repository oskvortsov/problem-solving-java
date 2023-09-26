package topic.two.points;

// https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int ans = 0;

        int l = 0, r = height.length - 1;

        while (l < r) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, cur);

            if (height[l] > height[r]) r--;
            else l++;
        }

        return ans;
    }
}
