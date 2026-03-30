class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int l=0, r=1;
        for(int i=0; i<prices.length - 1; ++i) {
            if(prices[l] < prices[r]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            } else {
                l = r;
            }
            ++r;
        }
        return maxP;
    }
}
