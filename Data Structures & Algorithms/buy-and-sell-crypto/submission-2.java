class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int max = 0;
        int l=0;
        for(int r=0; r<prices.length; ++r) {
            if(prices[l] > prices[r]) {
                l = r;
            }
            else {
                profit = prices[r] - prices[l];
                max = Math.max(max, profit);
            }
        }
        return max;
    }
}
