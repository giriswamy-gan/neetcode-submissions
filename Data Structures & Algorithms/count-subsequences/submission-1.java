class Solution {
    Map<String, Integer>[] memo;
    public int numDistinct(String s, String t) {
        memo = new HashMap[s.length()];
        for(int i = 0; i < s.length(); ++i) {
            memo[i] = new HashMap<>();
        }
        return dfs(0, "", s, t);
    }

    private int dfs(int i, String cur, String s, String t) {
        if(i == s.length()) {
            return cur.equals(t) ? 1 : 0;
        }
        if(memo[i].containsKey(cur)) return memo[i].get(cur);
        int skip = dfs(i + 1, cur, s, t);
        int take = dfs(i + 1, cur + s.charAt(i), s, t);
        memo[i].put(cur, skip + take);
        return memo[i].get(cur);
    }
}
