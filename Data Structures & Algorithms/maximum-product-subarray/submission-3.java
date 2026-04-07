class Solution {
    public int maxProduct(int[] nums) {
        int maxP = 1, minP = 1;
        int res = nums[0];
        for(int n : nums) {
            int tmp = maxP;
            maxP = Math.max(Math.max(maxP * n, minP * n), n);
            minP = Math.min(Math.min(minP * n, tmp * n), n);
            res = Math.max(res, maxP);
        }
        return res;
    }
}
