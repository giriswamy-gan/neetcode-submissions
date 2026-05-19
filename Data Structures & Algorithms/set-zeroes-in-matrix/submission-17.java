class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        boolean rowleft = false;

        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                if(matrix[r][c] == 0) {
                    if(r == 0) {
                        rowleft = true;
                    }
                    else {
                        matrix[r][0] = 0;
                    }
                    matrix[0][c] = 0;
                }
            }
        }

        for(int r = 1; r < ROWS; ++r) {
            for(int c = 1; c < COLS; ++c) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int r = 1; r < ROWS; ++r) {
                matrix[r][0] = 0;
            }
        }

        if(rowleft) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
