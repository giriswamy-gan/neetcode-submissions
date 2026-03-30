class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        int target = sum / 2;
        memo = new Boolean[nums.length][target + 1];
        return dfs(0, target, nums);
    }

    private boolean dfs(int i, int target, int[] nums) {
        if(target < 0) return false;
        if(i == nums.length) {
            return target == 0;
        }
        if(memo[i][target] != null) return memo[i][target];

        return memo[i][target] = dfs(i + 1, target, nums) || dfs(i + 1, target - nums[i], nums);
    }
}
