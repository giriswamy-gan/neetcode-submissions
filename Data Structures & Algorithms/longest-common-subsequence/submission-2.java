class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        for(int r = text1.length() - 1; r >= 0; --r) {
            int[] cur = new int[text2.length() + 1];
            for(int c = text2.length() - 1; c >= 0; --c) {
                if(text1.charAt(r) == text2.charAt(c)) {
                    cur[c] = 1 + dp[c+1];
                }
                else {
                    cur[c] = Math.max(cur[c+1], dp[c]);
                }
            }
            dp = cur;
        }
        return dp[0];
    }
}
