class Solution {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int LIS = 0;
        for(int i = 0; i < nums.length; ++i) {
            LIS = Math.max(LIS, 1 + dfs(i, nums));
        }
        return LIS;
    }

    private int dfs(int i, int[] nums) {
        if(i == nums.length) return 0;
        if(memo[i] != -1) return memo[i];

        int res = 0;
        for(int j = i + 1; j < nums.length; ++j) {
            if(nums[j] > nums[i]) {
                res = Math.max(res, 1 + dfs(j, nums));
            }
        }
        return memo[i] = res;
    }
}
