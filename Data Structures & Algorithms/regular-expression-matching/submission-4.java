class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int i, int j) {
        if(j == p.length()) return i == s.length();
        if(memo[i][j] != null) return memo[i][j];

        boolean match = (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)));

        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            memo[i][j] = dfs(s, p, i, j + 2) || (match && dfs(s, p, i + 1, j));
        }
        else if(match) {
            memo[i][j] = dfs(s, p, i + 1, j + 1);
        }
        else {
            memo[i][j] = false;
        }
        return memo[i][j];
    }
}
