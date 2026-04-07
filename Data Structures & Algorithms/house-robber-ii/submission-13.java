class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;

        return Math.max(dfs(Arrays.copyOf(nums, n - 1)), dfs(Arrays.copyOfRange(nums, 1, n)));
    }

    private int dfs(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length + 2];
        for(int i = nums.length - 1; i >= 0; --i) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }

        return Math.max(dp[0], dp[1]);
    }
}
