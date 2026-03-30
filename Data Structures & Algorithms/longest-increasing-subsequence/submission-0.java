class Solution {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, Integer.MIN_VALUE);
    }

    private int dfs(int[] nums, int i, int parent) {
        if(i == nums.length) return 0;
        int res1 = 0;
        int res2 = 0;
        if(nums[i] > parent) {
            res1 = 1 + dfs(nums, i + 1, nums[i]);
        }
        res2 = dfs(nums, i + 1, parent);
        return Math.max(res1, res2);
    }
}
