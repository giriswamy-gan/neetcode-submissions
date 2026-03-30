class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int r = 0; r < coins.length + 1; ++r) {
            dp[r][amount] = 1;
        }
        for(int i = coins.length - 1; i >= 0; --i) {
            for(int j = amount - 1; j >= 0; --j) {
                dp[i][j] = dp[i + 1][j];
                if(coins[i] + j <= amount) {
                    dp[i][j] += dp[i][coins[i] + j];
                }
            }
        }
        return dp[0][0];
    }
}
