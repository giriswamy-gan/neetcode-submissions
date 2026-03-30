class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[amount] = 1;
        for(int i = coins.length - 1; i >= 0; --i) {
            int[] nextDp = new int[amount + 1];
            nextDp[amount] = 1;
            for(int j = amount - 1; j >= 0; --j) {
                nextDp[j] = dp[j];
                if(coins[i] + j <= amount) {
                    nextDp[j] += nextDp[coins[i] + j];
                }
            }
            dp = nextDp;
        }
        return dp[0];
    }
}
