class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;

        memo = new int[s.length() + 1][t.length() + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String s, String t) {
        if(j == t.length() && i == s.length()) return 1;
        if(i == s.length()) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        int res = 0;
        if(j < t.length() && s.charAt(i) == t.charAt(j)) {
            res = dfs(i + 1, j + 1, s, t);
        }
        res += dfs(i + 1, j, s, t);
        return memo[i][j] = res;
    }
}
