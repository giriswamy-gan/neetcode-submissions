class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {
        if(i == s.length() && j == p.length()) return true;
        if(j == p.length()) return false;
        if(memo[i][j] != null) return memo[i][j];

        boolean match = i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if(match) {
                memo[i][j] = dfs(i + 1, j, s, p) || dfs(i, j + 2, s, p);
            }
            else {
                memo[i][j] = dfs(i, j + 2, s, p);
            }
        }
        else if(match) {
            memo[i][j] = dfs(i + 1, j + 1, s, p);
        }
        else {
            memo[i][j] = false;
        }
        return memo[i][j];
    }
}
