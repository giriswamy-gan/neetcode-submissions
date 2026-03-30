class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = coins.length - 1; i >= 0; --i) {
            int[] cur = new int[amount + 1];
            cur[0] = 1;
            for(int a = 1; a <= amount; ++a) {
                if(a - coins[i] >= 0) {
                    cur[a] = dp[a];
                    cur[a] += cur[a - coins[i]];
                }
            }
            dp = cur;
        }
        
        return dp[amount];
    }
}
