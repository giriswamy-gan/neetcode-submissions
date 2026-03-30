class Solution {
    int[][] cache;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        cache = new int[nums.length][2];
        for(int i=0; i<cache.length; ++i) {
            Arrays.fill(cache[i], -1);
        }
        return Math.max(dfs(nums, 0, 1), dfs(nums, 1, 0));
    }

    private int dfs(int[] nums, int i, int flag) {
        if((i == nums.length - 1 && flag == 1) || i >= nums.length) return 0;
        if(cache[i][flag] != -1) return cache[i][flag];
        return cache[i][flag] = Math.max(nums[i] + dfs(nums, i + 2, flag), dfs(nums, i + 1, flag));
    }
}
