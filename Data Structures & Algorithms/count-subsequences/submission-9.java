class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;

        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i = m - 1; i >= 0; --i) {
            int[] nextDp = new int[n + 1];
            for(int j = n; j >= 0; --j) {
                if(j < n && s.charAt(i) == t.charAt(j)) {
                    nextDp[j] = dp[j + 1];
                }
                nextDp[j] += dp[j];
            }
            dp = nextDp;
        }

        return dp[0];
    }
}
