class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while(l <= r && top <= bottom) {
            if(l == r && top == bottom) {
                res.add(matrix[top][l]);
                break;
            }
            for(int i = l; i <= r; ++i) {
                res.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i <= bottom; ++i) {
                res.add(matrix[i][r]);
            }
            r--;
            if (top <= bottom) {
                for(int i = r; i >= l; --i) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (l <= r) {
                for(int i = bottom; i >= top; --i) {
                    res.add(matrix[i][l]);
                }
                l++;
            }

        }
        return res;
    }
}
