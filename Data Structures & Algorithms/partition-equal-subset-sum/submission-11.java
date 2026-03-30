class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int i = nums.length - 1; i >= 0; --i) {
            boolean[] nextDp = new boolean[target + 1];
            for(int j = 0; j <= target; ++j) {
                nextDp[j] = dp[j];
                if(j - nums[i] >= 0) {
                    nextDp[j] = nextDp[j] || dp[j - nums[i]];
                }
            }
            dp = nextDp;
        }
        return dp[target];
    }
}
