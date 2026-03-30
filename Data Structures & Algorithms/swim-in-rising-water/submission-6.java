class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, 0, 0});
        boolean[][] visit = new boolean[n][m];
        int res = grid[0][0];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int w = cur[0], i = cur[1], j = cur[2];
            if(visit[i][j]) continue;
            visit[i][j] = true;
            res = Math.max(res, w);
            if(i == n - 1 && j == m - 1) return res;

            for(int[] dir : directions) {
                int r = i + dir[0];
                int c = j + dir[1];
                if(r >= 0 && c >= 0 && r < n && c < m && !visit[r][c]) {
                    pq.add(new int[]{grid[r][c], r, c});
                }
            }
        }
        return res;
    }
}
