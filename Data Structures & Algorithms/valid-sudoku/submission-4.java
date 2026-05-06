class Solution {
    public boolean isValidSudoku(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        for(int r = 0; r < ROWS; ++r) {
            Set<Character> rowSet = new HashSet<>();
            for(int c = 0; c < COLS; ++c) {
                if(board[r][c] == '.') continue;
                if(rowSet.contains(board[r][c])) {
                    return false;
                }
                rowSet.add(board[r][c]);
            }
        }
        System.out.println("clear");

        for(int c = 0; c < COLS; ++c) {
            Set<Character> colSet = new HashSet<>();
            for(int r = 0; r < ROWS; ++r) {
                if(board[r][c] == '.') continue;
                if(colSet.contains(board[r][c])) {
                    return false;
                }
                colSet.add(board[r][c]);
            }
        }
        System.out.println("clear");

        for(int grid = 0; grid < 9; ++grid) {
            Set<Character> gridSet = new HashSet<>();
            for(int r = 0; r < 3; ++r) {
                for(int c = 0; c < 3; ++c) {
                    int row = (grid / 3) * 3 + r;
                    int col = (grid % 3) * 3 + c;
                    if(board[row][col] == '.') continue;
                    if(gridSet.contains(board[row][col])) {
                        return false;
                    }
                    gridSet.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
