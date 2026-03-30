class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int res = 0;
        for(int r = 1; r < prices.length; ++r) {
            if(prices[r] < prices[l]) {
                l = r;
            } else {
                res = Math.max(res, prices[r] - prices[l]);
            }
        }
        return res;
    }
}
