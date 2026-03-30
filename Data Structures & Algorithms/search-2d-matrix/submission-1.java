class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int ROWS = matrix.length;
        final int COLS = matrix[0].length;
        int l = 0;
        int r = ROWS - 1;
        int targetRow = l;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(target >= matrix[m][0] && target <= matrix[m][COLS - 1]) {
                targetRow = m;
                break;
            }
            else if(target < matrix[m][0]) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        if(l > r) return false;

        int left = 0;
        int right = COLS - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == matrix[targetRow][mid]) {
                return true;
            }
            else if(target < matrix[targetRow][mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
