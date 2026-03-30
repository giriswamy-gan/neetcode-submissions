class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int n = s.length(), m = t.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for(int r = t.length() - 1; r >= 0; --r) {
            int[] cur = new int[n + 1];
            for(int c = s.length() - 1; c >= 0; --c) {
                cur[c] = cur[c + 1];
                if(s.charAt(c) == t.charAt(r)) {
                    cur[c] += dp[c + 1];
                }
            }
            dp = cur;
        }
        return dp[0];
    }
}
