class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS;
    int COLS;
    boolean[][] visit;

    public int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        visit = new boolean[ROWS][COLS];

        int res = 0;
        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                res = Math.max(res, dfs(r, c, matrix));
            }
        }
        return res + 1;
    }

    private int dfs(int r, int c, int[][] matrix) {
        int res = 0;
        for(int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS &&
            matrix[nr][nc] < matrix[r][c] && matrix[nr][nc] != -1) {
                int cur = matrix[nr][nc];
                visit[nr][nc] = true;
                res = Math.max(res, 1 + dfs(nr, nc, matrix));
                visit[nr][nc] = false;
            }
        }
        return res;
    }
}
