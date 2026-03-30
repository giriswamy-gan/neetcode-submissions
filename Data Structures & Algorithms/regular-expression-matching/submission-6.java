class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for(int i = m; i >= 0; --i) {
            boolean[] cur = new boolean[n + 1];
            if(i == m) cur[n] = true;
            for(int j = n - 1; j >= 0; --j) {
                boolean match = (i < m && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)));

                if(j + 1 < n && p.charAt(j + 1) == '*') {
                    cur[j] = cur[j + 2] || (match && dp[j]);
                }
                else {
                    cur[j] = match && dp[j + 1];
                }
            }
            dp = cur;
        }

        return dp[0];
    }
}
