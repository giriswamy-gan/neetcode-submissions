class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS;
    int COLS;
    boolean[][] pacific;
    boolean[][] atlantic;
    boolean[][] visit;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        pacific = new boolean[ROWS][COLS];
        atlantic = new boolean[ROWS][COLS];
        visit = new boolean[ROWS][COLS];
        List<List<Integer>> res = new ArrayList<>();

        for(int r=0; r<ROWS; ++r) {
            dfs(r, 0, heights, pacific);
            dfs(r, COLS-1, heights, atlantic);
        }

        for(int c=0; c<COLS; ++c) {
            dfs(0, c, heights, pacific);
            dfs(ROWS-1, c, heights, atlantic);
        }

        for(int r=0; r<ROWS; ++r) {
            for(int c=0; c<COLS; ++c) {
                if(pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean) {
        ocean[r][c] = true;
        for(int[] dir : directions) {
            int nr = dir[0] + r;
            int nc = dir[1] + c;
            if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !visit[nr][nc] && heights[r][c] <= heights[nr][nc]) {
                visit[nr][nc] = true;
                dfs(nr, nc, heights, ocean);
                visit[nr][nc] = false;
            }
        }
    }
}
