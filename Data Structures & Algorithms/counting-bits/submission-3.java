class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}

// 0 - 0000
// 1 - 0001
// 2 - 0010
// 3 - 0011
// 4 - 0100
// 5 - 0101
// 6 - 0110