class Solution {
    public int maxProduct(int[] nums) {
        int maxP = 1;
        int minP = 1;
        int res = nums[0];
        for(int num : nums) {
            int tmp = maxP;
            maxP = Math.max(Math.max(maxP * num, minP * num), num);
            minP = Math.min(Math.min(minP * num, tmp * num), num);
            res = Math.max(res, maxP);
        }
        return res;
    }
}
