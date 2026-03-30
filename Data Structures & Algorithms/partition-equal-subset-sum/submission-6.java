class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;

        int target = sum / 2;
        return dfs(0, 0, target, nums);
    }

    private boolean dfs(int i, int cur, int target, int[] nums) {
        if(i == nums.length) {
            return cur == target;
        }

        return dfs(i + 1, cur, target, nums) || dfs(i + 1, cur + nums[i], target, nums);
    }
}
