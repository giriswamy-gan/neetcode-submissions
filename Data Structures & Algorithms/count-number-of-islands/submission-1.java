class Solution {
    int ROWS;
    int COLS;
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        int count = 0;
        for(int i=0; i<ROWS; ++i) {
            for(int j=0; j<COLS; ++j) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, char[][] grid) {
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }
}
