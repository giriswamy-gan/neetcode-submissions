class Solution {
    public int trap(int[] height) {
        if(height.length == 1 || height.length == 2) return 0;
        int res = 0;
        for(int i=1; i<height.length-1; ++i) {
            int leftMaxHeight = height[i];
            int rightMaxHeight = height[i];
            for(int j=0; j<i; ++j) {
                leftMaxHeight = Math.max(height[j], leftMaxHeight);
            }
            for(int j=i+1; j<height.length; ++j) {
                rightMaxHeight = Math.max(height[j], rightMaxHeight);
            }
            int sum = Math.min(leftMaxHeight, rightMaxHeight) - height[i];
            if(sum > 0) {
                res += sum;
            }
        }
        return res;
    }
}
