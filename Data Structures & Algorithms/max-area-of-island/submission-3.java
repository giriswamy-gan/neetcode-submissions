class Solution {
    int ROWS;
    int COLS;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int res = 0;

        for(int i=0; i<ROWS; ++i) {
            for(int j=0; j<COLS; ++j) {
                if(grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    private int dfs(int r, int c, int[][] grid) {
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int count = 1 + dfs(r + 1, c, grid) + dfs(r - 1, c, grid) + dfs(r, c + 1, grid) + dfs(r, c - 1, grid);
        return count;
    }
}
