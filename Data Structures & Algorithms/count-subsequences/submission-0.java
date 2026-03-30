class Solution {
    public int numDistinct(String s, String t) {
        return dfs(0, "", s, t);
    }

    private int dfs(int i, String cur, String s, String t) {
        if(i == s.length()) {
            return cur.equals(t) ? 1 : 0;
        }
        int skip = dfs(i + 1, cur, s, t);
        int take = dfs(i + 1, cur + s.charAt(i), s, t);
        return skip + take;
    }
}
