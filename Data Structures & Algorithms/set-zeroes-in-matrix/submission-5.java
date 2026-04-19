class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        boolean[] row = new boolean[ROWS];
        boolean[] col = new boolean[COLS];

        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                if(matrix[r][c] == 0) {
                    row[r] = true;
                    col[c] =  true;
                }
            }
        }

        for(int r = 0; r < ROWS; ++r) {
            if(row[r]) {
                for(int c = 0; c < COLS; ++c) {
                    matrix[r][c] = 0;
                }
            }
        }

        for(int c = 0; c < COLS; ++c) {
            if(col[c]) {
                for(int r = 0; r < ROWS; ++r) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
