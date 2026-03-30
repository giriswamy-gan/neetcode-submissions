class Solution {
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < ROWS; ++r) {
            if(board[r][0] == 'O') {
                board[r][0] = '#';
                q.add(new int[]{r, 0});
            }
            if(board[r][COLS-1] == 'O') {
                board[r][COLS-1] = '#';
                q.add(new int[]{r, COLS-1});
            }
        }
        for(int c = 0; c < COLS; ++c) {
            if(board[0][c] == 'O') {
                board[0][c] = '#';
                q.add(new int[]{0, c});
            }
            if(board[ROWS-1][c] == 'O') {
                board[ROWS-1][c] = '#';
                q.add(new int[]{ROWS-1, c});
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && board[nr][nc] == 'O') {
                    board[nr][nc] = '#';
                    q.add(new int[]{nr, nc});
                }
            }
        }

        for(int r=0; r<ROWS; ++r) {
            for(int c=0; c<COLS; ++c) {
                if(board[r][c] == '#') {
                    board[r][c] = 'O';
                }
                else if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
