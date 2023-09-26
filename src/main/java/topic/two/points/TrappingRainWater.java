package topic.two.points;

public class TrappingRainWater {
    public int trap(int[] height) {
       int ans = 0;

       int l = 0, r = height.length - 1;
       int lMax = height[l], rMax = height[r];

       while (l < r) {
           if (lMax < rMax) {
               lMax = Math.max(lMax, height[++l]);
               ans += lMax - height[l];
           } else {
               rMax = Math.max(rMax, height[--r]);
               ans += rMax - height[r];
           }
       }

        return ans;
    }
}
