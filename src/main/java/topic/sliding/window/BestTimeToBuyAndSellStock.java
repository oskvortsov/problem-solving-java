package topic.sliding.window;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// 7,1,5,3,6,4
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int prev = prices[0];
        int profit = 0;

        for (int price: prices) {
            profit = Math.max(price - prev, profit);
            prev = Math.min(prev, price);
        }

        return profit;
    }
}
