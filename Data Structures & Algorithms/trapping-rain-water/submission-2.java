class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 1) return 0;
        int l = 0, r = height.length-1;
        int maxL = height[l], maxR = height[r];
        int res = 0;
        while(l < r) {
            if(maxL < maxR) {
                ++l;
                maxL = Math.max(maxL, height[l]);
                res += Math.max(maxL - height[l], 0);
            } else {
                --r;
                maxR = Math.max(maxR, height[r]);
                res += Math.max(maxR - height[r], 0);
            }
        }
        return res;
    }
}
