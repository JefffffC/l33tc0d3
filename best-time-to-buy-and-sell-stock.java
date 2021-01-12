// Optimal solution

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;
            if (profit > 0 && profit > maxProfit) {
                maxProfit = profit;
            } else {
                if (prices[i] < min) {
                    min = prices[i];
                }
            }
        }
        return maxProfit;
    }
}