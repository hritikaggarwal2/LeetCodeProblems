class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int minIndex = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[minIndex] > prices[i]) {
                minIndex = i;
            } else if (prices[i] - prices[minIndex] > max) {
                max = prices[i] - prices[minIndex];
            }
        }

        return max;
    }
}