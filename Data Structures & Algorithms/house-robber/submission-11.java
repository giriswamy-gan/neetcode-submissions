class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int a = 0;
        int b = nums[nums.length - 1];
        for(int i = nums.length-2; i >= 0; i--) {
            nums[i] = Math.max(nums[i] + a, b);
            a = b;
            b = nums[i];
        }
        return Math.max(nums[0], nums[1]);
    }
}
