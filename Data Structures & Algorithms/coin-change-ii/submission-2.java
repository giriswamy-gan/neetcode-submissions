class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < coins.length; ++i) {
            dp[i][0] = 1;
        }

        for(int i = coins.length - 1; i >= 0; --i) {
            for(int a = 1; a <= amount; ++a) {
                if(a >= coins[i]) {
                    dp[i][a] = dp[i+1][a];
                    dp[i][a] += dp[i][a - coins[i]];
                }
            }
        }
        return dp[0][amount];
    }
}
