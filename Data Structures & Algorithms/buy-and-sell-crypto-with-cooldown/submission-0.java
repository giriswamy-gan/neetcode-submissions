class Solution {
    public int maxProfit(int[] prices) {
        return dfs(-1, 0, prices);
    }

    private int dfs(int buyIdx, int i, int[] prices) {
        if(i >= prices.length) return 0;
        if(buyIdx == -1) {
            return Math.max(dfs(i, i + 1, prices),
                            dfs(-1, i + 1, prices));
        }
        else {
            int p1 = 0;
            if(prices[i] > prices[buyIdx]) {
                p1 = prices[i] - prices[buyIdx] + dfs(-1, i + 2, prices);
            }
            return Math.max(p1, dfs(buyIdx, i + 1, prices));
        }
    }
}
