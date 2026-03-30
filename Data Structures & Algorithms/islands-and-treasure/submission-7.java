class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int r=0; r<grid.length; ++r) {
            for(int c=0; c<grid[0].length; ++c) {
                if(grid[r][c] == 0) {
                    q.add(new int[]{r, c, 0});
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], w = cur[2];
            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = w + 1;
                    q.add(new int[]{nr, nc, w + 1});
                }
            }
        }
    }
}
