class Solution {
    int ROWS;
    int COLS;
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for(int r=0; r<ROWS; ++r) {
            for(int c=0; c<COLS; ++c) {
                if(grid[r][c] == 0) {
                    dfs(r, c, grid, 0);
                }
            }
        }
    }

    private void dfs(int r, int c, int[][] grid, int dist) {
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == -1 || (dist > 0 && grid[r][c] <= dist)) {
            return;
        }

        grid[r][c] = Math.min(grid[r][c], dist);

        dfs(r + 1, c, grid, dist + 1);
        dfs(r - 1, c, grid, dist + 1);
        dfs(r, c + 1, grid, dist + 1);
        dfs(r, c - 1, grid, dist + 1);
    }
}
