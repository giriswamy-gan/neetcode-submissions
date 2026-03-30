class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        for(int i = nums.length-3; i >= 0; i--) {
            nums[i] = Math.max(nums[i] + nums[i+2], nums[i+1]);
        }
        return Math.max(nums[0], nums[1]);
    }
}
