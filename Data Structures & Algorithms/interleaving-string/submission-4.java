class Solution {
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        memo = new Boolean[s3.length()][s3.length()];
        return dfs(0, 0, 0, s1, s2, s3);
    }

    private boolean dfs(int i1, int i2, int i3, String s1, String s2, String s3) {
        if(i3 == s3.length()) {
            if(i1 < s1.length() || i2 < s2.length()) return false;
            else return true;
        }
        if(memo[i1][i2] != null) return memo[i1][i2];

        if(i1 < s1.length() && i2 < s2.length() && 
          s1.charAt(i1) == s2.charAt(i2) && s2.charAt(i2) == s3.charAt(i3)) {
            memo[i1][i2] = dfs(i1 + 1, i2, i3 + 1, s1, s2, s3) || dfs(i1, i2 + 1, i3 + 1, s1, s2, s3);
        }
        else if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            memo[i1][i2] = dfs(i1 + 1, i2, i3 + 1, s1, s2, s3);
        }
        else if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            memo[i1][i2] = dfs(i1, i2 + 1, i3 + 1, s1, s2, s3);
        }
        else {
            memo[i1][i2] = false;
        }
        return memo[i1][i2];
    }
}
