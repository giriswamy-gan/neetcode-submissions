class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length() < s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int m = s1.length(), n = s2.length();

        boolean[] dp = new boolean[n + 1];

        for(int i = m; i >= 0; --i) {
            boolean[] cur = new boolean[n + 1];
            if(i == m) cur[n] = true;
            for(int j = n; j >= 0; --j) {
                if(i < m && s1.charAt(i) == s3.charAt(i + j) && dp[j]) {
                    cur[j] = true;
                }
                if(j < n && s2.charAt(j) == s3.charAt(i + j) && cur[j + 1]) {
                    cur[j] = true;
                }
            }
            dp = cur;
        }

        return dp[0];
    }
}
