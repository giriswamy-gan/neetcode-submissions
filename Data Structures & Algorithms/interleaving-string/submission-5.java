class Solution {
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        memo = new Boolean[s3.length()][s3.length()];
        return dfs(0, 0, 0, s1, s2, s3);
    }

    private boolean dfs(int i1, int i2, int i3, String s1, String s2, String s3) {
        if(i3 == s3.length()) {
            return i1 < s1.length() || i2 < s2.length() ? false : true;
        }
        if(memo[i1][i2] != null) return memo[i1][i2];

        boolean res = false;
        if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            res = dfs(i1 + 1, i2, i3 + 1, s1, s2, s3);
        }
        if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            res = dfs(i1, i2 + 1, i3 + 1, s1, s2, s3);
        }
        return memo[i1][i2] = res;
    }
}
