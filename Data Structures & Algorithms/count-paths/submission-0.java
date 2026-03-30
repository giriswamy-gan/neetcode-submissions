class Solution {
    int[][] grid;
    public int uniquePaths(int m, int n) {
        grid = new int[m][n];

        grid[m-1][n-1] = 1;
        return dfs(0, 0, m, n);
    }

    private int dfs(int r, int c, int m, int n) {
        if(r >= m || c >= n) return 0;
        if(grid[r][c] != 0) return grid[r][c];

        return grid[r][c] = dfs(r + 1, c, m, n) + dfs(r, c + 1, m, n);
    }
}
