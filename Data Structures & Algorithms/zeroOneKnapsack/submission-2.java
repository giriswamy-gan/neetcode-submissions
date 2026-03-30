class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] dp = new int[weight.size()][capacity + 1];
        for(int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for(int r=0; r<dp.length; ++r) {
            dp[r][0] = 0;
        }
        for(int c=0; c<=capacity; ++c) {
            if(c - weight.get(0) >= 0) {
                dp[0][c] = profit.get(0);
            }
        }

        for(int i=1; i<dp.length; ++i) {
            for(int c=1; c<=capacity; ++c) {
                int skip = dp[i - 1][c];
                int include = 0;
                if(c - weight.get(i) >= 0) {
                    include = profit.get(i) + dp[i-1][c - weight.get(i)];
                }
                dp[i][c] = Math.max(skip, include);
            }
        }
        return dp[weight.size()-1][capacity];
    }
}
