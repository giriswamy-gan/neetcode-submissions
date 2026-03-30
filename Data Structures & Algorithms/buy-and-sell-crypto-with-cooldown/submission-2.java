class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for(int i = n - 1; i >= 0; --i) {
            for(int buying = 1; buying >= 0; --buying) {
                if(buying == 1) {
                    int buy = i + 1 < n ? dp[i+1][0] - prices[i] : -1 * prices[i];
                    dp[i][1] = Math.max(buy, dp[i+1][1]);
                }
                else {
                    int sell = i + 2 < n ? dp[i+2][1] + prices[i] : prices[i];
                    dp[i][0] = Math.max(sell, dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
