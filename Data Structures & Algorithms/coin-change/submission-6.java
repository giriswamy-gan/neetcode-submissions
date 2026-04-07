class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int) 1e6);
        dp[0] = 0;

        for(int i = 1; i <= amount; ++i) {
            for(int coin : coins) {
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] >= (int) 1e6 ? -1 : dp[amount];
    }
}
