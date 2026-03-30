class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int n = s.length(), m = t.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[m], 1);

        for(int r = t.length() - 1; r >= 0; --r) {
            for(int c = s.length() - 1; c >= 0; --c) {
                dp[r][c] = dp[r][c + 1];
                if(s.charAt(c) == t.charAt(r)) {
                    dp[r][c] += dp[r + 1][c + 1];
                }
            }
        }
        return dp[0][0];
    }
}
