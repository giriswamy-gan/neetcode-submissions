class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ROWS;
    int COLS;

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Deque<int[]> q = new LinkedList<>();

        for(int r=0; r<ROWS; ++r) {
            for(int c=0; c<COLS; ++c) {
                if(grid[r][c] == 0) {
                    q.add(new int[]{r, c});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];

            for(int[] dir: directions) {
                int dR = row + dir[0];
                int dC = col + dir[1];
                if(dR < 0 || dC < 0 || dR >= ROWS || dC >= COLS || grid[dR][dC] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[dR][dC] = grid[row][col] + 1;
                q.add(new int[]{dR, dC});
            }
        }
    }
}
