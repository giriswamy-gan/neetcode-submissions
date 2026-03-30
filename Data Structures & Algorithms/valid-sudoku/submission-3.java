class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int r=0; r<9; ++r) {
            Set<Character> rowSet = new HashSet<>();
            for(int c=0; c<9; ++c) {
                if(board[r][c] == '.') continue;
                if(rowSet.contains(board[r][c])) return false;
                rowSet.add(board[r][c]);
            }
        }

        for(int c=0; c<9; ++c) {
            Set<Character> colSet = new HashSet<>();
            for(int r=0; r<9; ++r) {
                if(board[r][c] == '.') continue;
                if(colSet.contains(board[r][c])) return false;
                colSet.add(board[r][c]);
            }
        }

        for(int grid=0; grid<9; ++grid) {
            Set<Character> gridSet = new HashSet<>();
            // System.out.println(grid);
            for(int i=0; i<9; ++i) {
                int c = (i % 3) + (grid % 3) * 3;
                int r = (i / 3) + (grid / 3) * 3;
                // System.out.println(r + " " + c);
                if(board[r][c] == '.') continue;
                if(gridSet.contains(board[r][c])) return false;
                gridSet.add(board[r][c]);
            }
        }

        return true;
    }
}
