class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int heightL = height[l];
        int heightR = height[r];

        while(l < r) {
            if(heightL < heightR) {
                l++;
                heightL = Math.max(heightL, height[l]);
                res += heightL - height[l];
            } else {
                r--;
                heightR = Math.max(heightR, height[r]);
                res += heightR - height[r];
            }
        }
        return res;
    }
}
