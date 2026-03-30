class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int curSum, int[] nums, int target) {
        if(i == nums.length) {
            if(curSum == target) return 1;
            else return 0;
        }

        return dfs(i + 1, curSum - nums[i], nums, target) + dfs(i + 1, curSum + nums[i], nums, target);
    }
}
