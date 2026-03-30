class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top=0, bottom=matrix.length-1;
        while(top<=bottom) {
            int m = (top + bottom)/2;
            if(target < matrix[m][0]) {
                bottom = m - 1;
            } 
            else if(target > matrix[m][cols-1]) {
                top = m + 1;
            }
            else {
                break;
            }
        }
        System.out.println("exited");
        if(!(top<=bottom)) {
            return false;
        }

        int l=0, r=matrix[0].length - 1;
        int row = (top + bottom)/2;
        while(l <= r) {
            int m = l + ((r-l)/2);
            if(target < matrix[row][m]) {
                r = m - 1;
            }
            else if(target > matrix[row][m]) {
                l = m + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
