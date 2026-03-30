class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        int target = sum / 2;
        memo = new Boolean[nums.length][target + 1];
        return dfs(0, nums, target);
    }

    private boolean dfs(int i, int[] nums, int target) {
        if(i == nums.length) return target == 0;
        if(target < 0) return false;
        if(memo[i][target] != null) return memo[i][target];

        memo[i][target] = dfs(i + 1, nums, target - nums[i]) ||
                        dfs(i + 1, nums, target);
        return memo[i][target];
    }
}
