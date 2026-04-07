class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                if(matrix[r][c] == 0) {
                    rowSet.add(r);
                    colSet.add(c);
                }
            }
        }

        for(int r : rowSet) {
            Arrays.fill(matrix[r], 0);
        }

        for(int c : colSet) {
            for(int r = 0; r < ROWS; ++r) {
                matrix[r][c] = 0;
            }
        }
    }
}
