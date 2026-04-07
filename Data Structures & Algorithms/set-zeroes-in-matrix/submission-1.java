class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        boolean[] rowZero = new boolean[ROWS];
        boolean[] colZero = new boolean[COLS];

        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                if(matrix[r][c] == 0) {
                    rowZero[r] = true;
                    colZero[c] = true;
                }
            }
        }

        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                if(rowZero[r] || colZero[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
