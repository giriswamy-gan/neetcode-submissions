class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; ++i) {
            int curProduct = 1;
            for(int j=i; j<nums.length; ++j) {
                curProduct *= nums[j];
                res = Math.max(res, curProduct);
            }
        }
        return res;
    }
}
