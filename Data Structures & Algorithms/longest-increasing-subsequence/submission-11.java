class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        for(int i = n - 2; i >= 0; --i) {
            int res = 0;
            for(int j = i + 1; j < n; ++j) {
                if(nums[j] > nums[i]) {
                    res = Math.max(res, 1 + dp[j]);
                }
            }
            dp[i] = res;
        }
        return 1 + Arrays.stream(dp).max().getAsInt();
    }
}
