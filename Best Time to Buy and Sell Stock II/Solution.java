class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0, sell = -1;
        for (int i = len - 1; i >= 0; i--) {
            int currentPrice = prices[i];
            if (sell == -1) {
                sell = currentPrice;
                continue;
            }

            if (currentPrice < sell) {
                profit += sell - currentPrice;
            }

            sell = currentPrice;
        }

        return profit;
    }
}