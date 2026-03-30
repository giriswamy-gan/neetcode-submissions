class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int r=0; r<9; ++r) {
            Set<Character> colSet = new HashSet<>();
            for(int c=0; c<9; ++c) {
                if(board[r][c] != '.' && colSet.contains(board[r][c])) {
                    return false;
                }
                colSet.add(board[r][c]);
            }
        }

        for(int c=0; c<9; ++c) {
            Set<Character> rowSet = new HashSet<>();
            for(int r=0; r<9; ++r) {
                if(board[r][c] != '.' && rowSet.contains(board[r][c])) {
                    return false;
                }
                rowSet.add(board[r][c]);
            }
        }

        for(int g=0; g<9; ++g) {
            Set<Character> gridSet = new HashSet<>();
            for(int i=0; i<3; ++i) {
                for(int j=0; j<3; ++j) {
                    int r = g / 3 * 3 + i;
                    int c = g % 3 * 3 + j;
                    if(board[r][c] != '.' && gridSet.contains(board[r][c])) {
                        return false;
                    }
                    gridSet.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
