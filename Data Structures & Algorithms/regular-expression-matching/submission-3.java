class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int i, int j) {
        if(j == p.length()) return i == s.length();

        boolean match = (i < s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)));

        if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return dfs(s, p, i, j + 2) || (match && dfs(s, p, i + 1, j));
        }
        if(match) return dfs(s, p, i + 1, j + 1);
        return false;
    }
}
