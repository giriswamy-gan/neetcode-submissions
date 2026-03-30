class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for(int i = n - 2; i >= 0; --i) {
            for(int j = i + 1; j <= i + nums[i]; ++j) {
                if(j < n && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[0];
    }
}
