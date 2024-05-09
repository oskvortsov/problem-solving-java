package topic.array;

public class BestTimeToBuyAndSellStockTwo {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int cur = prices[0];

        for (int price: prices) {
            ans += Math.max(price - cur, 0);
            cur = price;
        }

        return ans;
    }
}
