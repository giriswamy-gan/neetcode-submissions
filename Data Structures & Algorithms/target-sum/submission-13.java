class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, target);
    }

    private int dfs(int i, int[] nums, int target) {
        if(i == nums.length) return target == 0 ? 1 : 0;
        return dfs(i + 1, nums, target - nums[i]) + dfs(i + 1, nums, target + nums[i]);
    }
}
