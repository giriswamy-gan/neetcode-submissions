class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS;
    int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        for(int c=0; c<COLS; ++c) {
            dfs(0, c, pacific, heights);
            dfs(ROWS-1, c, atlantic, heights);
        }
        for(int r=0; r<ROWS; ++r) {
            dfs(r, 0, pacific, heights);
            dfs(r, COLS-1, atlantic, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r<ROWS; ++r) {
            for(int c=0; c<COLS; ++c) {
                if(pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for(int[] dir: directions) {
            int row = r + dir[0];
            int col = c + dir[1];
            if(row >= 0 && col >= 0 && row < ROWS && col < COLS && heights[row][col] >= heights[r][c] && !ocean[row][col]) {
                dfs(row, col, ocean, heights);
            }
        }
    }
}
