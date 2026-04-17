class Solution {
    public int maxProduct(int[] nums) {
        int maxP = nums[0], minP = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            int tmp = maxP * nums[i];
            maxP = Math.max(Math.max(maxP * nums[i], minP * nums[i]), nums[i]);
            minP = Math.min(Math.min(minP * nums[i], tmp), nums[i]);
            res = Math.max(res, maxP);
        }
        return res;
    }
}
