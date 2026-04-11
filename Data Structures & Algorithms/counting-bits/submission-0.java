class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int[] dp = new int[n + 1];
        int offset = 1;
        for(int i = 1; i <= n; ++i) {
            if(offset * 2 == i) {
                offset = i;
            }
            res[i] = 1 + dp[i - offset];
            dp[i] = res[i];
        }
        return res;
    }
}
