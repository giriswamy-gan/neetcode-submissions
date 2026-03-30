class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        int maxPre = 0;
        for(int i=0; i<n; ++i) {
            pre[i] = maxPre;
            maxPre = Math.max(maxPre, height[i]);
        }

        int maxSuf = 0;
        for(int i=n-1; i>0; --i) {
            suf[i] = maxSuf;
            maxSuf = Math.max(maxSuf, height[i]);
        }

        int res = 0;
        for(int i=0; i<n; ++i) {
            int curSum = 0;
            if(pre[i] > height[i] && suf[i] > height[i]) {
                curSum += Math.min(pre[i], suf[i]) - height[i];
            }
            res += curSum;
        }
        return res;
    }
}
