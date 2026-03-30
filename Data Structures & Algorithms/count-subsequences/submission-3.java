class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;
        memo = new int[s.length()][t.length()];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        int skip = dfs(s, t, i + 1, j);
        int take = 0;
        if(s.charAt(i) == t.charAt(j)) {
            take = dfs(s, t, i + 1, j + 1);
        }
        return memo[i][j] = skip + take;
    }
}
