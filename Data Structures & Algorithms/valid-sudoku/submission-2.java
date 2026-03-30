class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int ROWS = board.length;
        final int COLS = board[0].length;

        for(int r=0; r<ROWS; ++r) {
            Set<Character> colSet = new HashSet<>();
            for(int c=0; c<COLS; ++c) {
                if(board[r][c] == '.') continue;
                if(colSet.contains(board[r][c])) return false;
                colSet.add(board[r][c]);
            }
        }

        for(int c=0; c<COLS; ++c) {
            Set<Character> rowSet = new HashSet<>();
            for(int r=0; r<ROWS; ++r) {
                if(board[r][c] == '.') continue;
                if(rowSet.contains(board[r][c])) return false;
                rowSet.add(board[r][c]);
            }
        }

        for(int i=0; i<9; ++i) {
            Set<Character> gridSet = new HashSet<>();
            for(int j=0; j<9; ++j) {
                int row = j / 3 + (i / 3) * 3;
                int col = j % 3 + (i % 3) * 3;
                if(board[row][col] == '.') continue;
                if(gridSet.contains(board[row][col])) return false;
                gridSet.add(board[row][col]);
            }
        }
        return true;
    }
}
