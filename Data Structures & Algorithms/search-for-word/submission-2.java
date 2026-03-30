class Solution {
    int ROWS;
    int COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        

        for(int i=0; i<ROWS; ++i) {
            for(int j=0; j<COLS; ++j) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, int i, String word) {
        if(i == word.length()) {
            return true;
        }

        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] == '#' || board[r][c] != word.charAt(i)) {
            return false;
        }

        board[r][c] = '#';

        boolean res = dfs(board, r + 1, c, i + 1, word) || dfs(board, r - 1, c, i + 1, word) ||
                      dfs(board, r, c + 1, i + 1, word) || dfs(board, r, c - 1, i + 1, word);
        
        board[r][c] = word.charAt(i);
        return res;
    }
}
