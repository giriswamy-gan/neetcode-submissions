class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String s1, String s2, int i, int j) {
        if(j == s2.length()) {
            return s1.length() - i;
        }
        if(i == s1.length()) return s2.length() - j;

        if(s1.charAt(i) == s2.charAt(j)) {
            return dfs(s1, s2, i + 1, j + 1);
        }
        return Math.min(1 + dfs(s1, s2, i + 1, j + 1), Math.min(1 + dfs(s1, s2, i + 1, j), 1 + dfs(s1, s2, i, j + 1)));
    }
}
