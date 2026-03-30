class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, text1, text2);
    }

    private int dfs(int i1, int i2, String s1, String s2) {
        if(i1 == s1.length() || i2 == s2.length()) return 0;
        if(memo[i1][i2] != -1) return memo[i1][i2];

        int p1 = 0;
        if(s1.charAt(i1) == s2.charAt(i2)) {
            p1 = 1 + dfs(i1 + 1, i2 + 1, s1, s2);
        }
        int p2 = Math.max(dfs(i1 + 1, i2, s1, s2), dfs(i1, i2 + 1, s1, s2));
        return memo[i1][i2] = Math.max(p1, p2);
    }
}
