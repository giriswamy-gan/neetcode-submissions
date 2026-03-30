class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{grid[0][0], 0, 0});

        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int t = cur[0];
            visit[cur[1]][cur[2]] = true;
            if(cur[1] == grid.length - 1 && cur[2] == grid[0].length - 1) {
                return cur[0];
            }
            for(int[] dir : directions) {
                int r = cur[1] + dir[0];
                int c = cur[2] + dir[1];
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && !visit[r][c]) {
                    minHeap.add(new int[]{Math.max(grid[r][c], t), r, c});
                }
            }
        }
        return -1;
    }
}
