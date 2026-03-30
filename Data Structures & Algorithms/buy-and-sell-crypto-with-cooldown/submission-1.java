class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(1, 0, prices);
    }

    private int dfs(int buying, int i, int[] prices) {
        if(i >= prices.length) return 0;
        if(memo[i][buying] != -1) return memo[i][buying];

        int cooldown = dfs(buying, i + 1, prices);
        if(buying == 1) {
            int buy = dfs(0, i + 1, prices) - prices[i];
            return memo[i][buying] = Math.max(buy, cooldown);
        }
        else {
            int sell = dfs(1, i + 2, prices) + prices[i];
            return memo[i][buying] = Math.max(sell, cooldown);
        }
    }
}
