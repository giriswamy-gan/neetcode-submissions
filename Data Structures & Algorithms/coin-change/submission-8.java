class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int res = dfs(coins, amount);
        return res >= (int) 1e9 ? -1 : res;
    }

    private int dfs(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(memo[amount] != -1) return memo[amount];

        int res = (int) 1e9;
        for(int coin : coins) {
            if(coin <= amount) {
                res = Math.min(res, 1 + dfs(coins, amount - coin));
            }
        }
        return memo[amount] = res;
    }
}
