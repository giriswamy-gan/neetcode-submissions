class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, amount, coins);
    }

    private int dfs(int i, int cur, int amount, int[] coins) {
        if(cur == amount) return 1;
        if(i == coins.length) return 0;
        if(memo[i][cur] != -1) return memo[i][cur];

        int res = dfs(i + 1, cur, amount, coins);

        if(coins[i] + cur <= amount) {
            res += dfs(i, coins[i] + cur, amount, coins);
        }
        
        return memo[i][cur] = res;
    }
}