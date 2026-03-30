class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new LinkedList<>();
        int count = 0;
        for(int r=0; r<grid.length; ++r) {
            for(int c=0; c<grid[0].length; ++c) {
                if(grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                }
                if(grid[r][c] == 1) {
                    count++;
                }
            }
        }

        int minute = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty() && count > 0) {
            int size = q.size();
            for(int i=0; i<size; ++i) {
                int[] pair = q.poll();
                int r = pair[0];
                int c = pair[1];
                for(int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if(row >= 0 && col >= 0 && row < grid.length && 
                    col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        count--;
                        q.add(new int[]{row, col});
                    }
                }
            }
            minute++;
        }
        return count == 0 ? minute : -1;
    }
}
