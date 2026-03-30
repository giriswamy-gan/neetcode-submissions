class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i=0; i<heights.length; ++i) {
            int cur = heights[i];
            int minHeight = heights[i];
            for(int j=i; j<heights.length; ++j) {
                minHeight = Math.min(minHeight, heights[j]);
                cur = minHeight * (j - i + 1);
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
