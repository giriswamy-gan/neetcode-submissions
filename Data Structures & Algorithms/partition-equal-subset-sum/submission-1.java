class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        return dfs(0, nums, sum / 2);
    }

    private boolean dfs(int i, int[] nums, int target) {
        if(target == 0) return true;
        if(i == nums.length || target < 0) return false;

        if(nums[i] <= target) {
            if(dfs(i + 1, nums, target - nums[i])) {
                return true;
            }
        }
        if(dfs(i + 1, nums, target)) {
            return true;
        }
        return false;
    }
}
