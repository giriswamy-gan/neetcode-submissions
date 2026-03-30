class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int r = m - 2; r >= 0; --r) {
            int[] cur = new int[n];
            cur[n-1] = 1;
            for(int c = n - 2; c >= 0; --c) {
                cur[c] = dp[c] + cur[c+1];
            }
            dp = cur;
        }

        return dp[0];
    }
}
