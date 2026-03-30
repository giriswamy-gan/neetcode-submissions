class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        Arrays.sort(coins); 
        return dfs(0, amount, coins);
    }

    private int dfs(int i, int amount, int[] coins) {
        if(amount == 0) return 1;
        if(i == coins.length) return 0;
        if(memo[i][amount] != -1) return memo[i][amount];

        int res = 0;
        if(amount >= coins[i]) {
            res = dfs(i + 1, amount, coins);
            res += dfs(i, amount - coins[i], coins);
        }
        return memo[i][amount] = res;
    }
}
