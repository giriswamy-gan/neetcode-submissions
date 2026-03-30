class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i=0; i<heights.length; ++i) {
            int l = Math.max(i-1, 0), r = Math.min(i + 1, heights.length-1);
            int width = 1;
            for(int j=0; j<heights.length; ++j) {
                if(l!=i && l>=0 && heights[l] >= heights[i]) {
                    ++width;
                    --l;
                }
                if(r!=i && r<heights.length && heights[r] >= heights[i]) {
                    ++width;
                    ++r;
                }
            }
            System.out.println(heights[i]);
            System.out.println(width);
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
