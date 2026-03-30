class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int r=0; r<ROWS; ++r) {
            for(int c=0; c<COLS; ++c) {
                if(grid[r][c] == 1) {
                    fresh++;
                }
                else if(grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
            }
        }
        if(fresh == 0) return 0;
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; ++i) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for(int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            time++;
        }
        return fresh > 0 ? -1 : time;
    }
}
