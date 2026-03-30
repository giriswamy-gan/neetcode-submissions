class Solution {
    Boolean[] memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        memo = new Boolean[nums.length];

        int target = sum / 2;
        return dfs(0, target, nums);
    }

    private boolean dfs(int i, int target, int[] nums) {
        if(i == nums.length) {
            return target == 0;
        }
        if(memo[i] != null) return memo[i];

        return dfs(i + 1, target, nums) || dfs(i + 1, target - nums[i], nums);
    }
}
