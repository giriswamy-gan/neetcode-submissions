class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}


// 0   0
// 01  1
// 10  2
// 11  3
// 100 4
// 101 5
// 110 6
// 111 7
