class Solution {
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int maxLis = 1;
        for(int i=0; i<nums.length; ++i) {
            maxLis = Math.max(maxLis, dfs(nums, i));
        }
        return maxLis;
    }

    private int dfs(int[] nums, int i) {
        if(i == nums.length) return 0;
        if(memo[i] != -1) return memo[i];

        int LIS = 1;
        for(int j = i + 1; j < nums.length; ++j) {
            if(nums[j] > nums[i]) {
                LIS = Math.max(LIS, 1 + dfs(nums, j));
            }
        }
        return memo[i] = LIS;
    }
}
