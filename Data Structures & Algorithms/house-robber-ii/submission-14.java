class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;

        return Math.max(dfs(Arrays.copyOf(nums, n - 1)), dfs(Arrays.copyOfRange(nums, 1, n)));
    }

    private int dfs(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int dp = 0;
        int dp1 = 0, dp2 = 0;
        for(int i = nums.length - 1; i >= 0; --i) {
            dp = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = dp;
        }

        return Math.max(dp1, dp2);
    }
}
