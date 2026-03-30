class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for(int j = 0; j <= n; ++j) {
            dp[j] = n - j;
        }

        for(int i = m - 1; i >= 0; --i) {
            int[] cur = new int[n + 1];
            cur[n] = m - i;
            for(int j = n - 1; j >= 0; --j) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    cur[j] = dp[j + 1];
                }
                else {
                    int res = Math.min(dp[j], cur[j + 1]);
                    cur[j] = 1 + Math.min(res, dp[j + 1]);
                }
            }
            dp = cur;
        }
        return dp[0];
    }
}
