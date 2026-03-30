class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i=0; i<heights.length; ++i) {
            int cur = heights[i];
            int leftHeight = i-1;
            int l = 0;
            int rightHeight = i+1;
            int r = 0;
            while(leftHeight >= 0 && cur <= heights[leftHeight]) {
                leftHeight--;
                l++;
            }
            while(rightHeight < heights.length && cur <= heights[rightHeight]) {
                rightHeight++;
                r++;
            }
            res = Math.max(res, heights[i] * (l + r + 1));
        }
        return res;
    }
}
