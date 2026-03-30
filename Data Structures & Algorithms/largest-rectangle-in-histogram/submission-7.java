class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i=0; i<heights.length; ++i) {
            int cur = heights[i];
            int leftHeight = i-1;
            int rightHeight = i+1;
            while(leftHeight >= 0 && cur <= heights[leftHeight]) {
                leftHeight--;
            }
            while(rightHeight < heights.length && cur <= heights[rightHeight]) {
                rightHeight++;
            }
            leftHeight++;
            rightHeight--;
            res = Math.max(res, heights[i] * (rightHeight - leftHeight + 1));
        }
        return res;
    }
}
