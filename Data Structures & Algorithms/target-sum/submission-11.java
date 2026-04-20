class Solution {
    int[][] memo;
    int offset;
    public int findTargetSumWays(int[] nums, int target) {
        offset = Arrays.stream(nums).sum();
        memo = new int[nums.length][(offset * 2) + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, nums, target, 0);
    }

    private int dfs(int i, int[] nums, int target, int curSum) {
        if(i == nums.length) return curSum == target ? 1 : 0;
        if(memo[i][curSum + offset] != -1) return memo[i][curSum + offset];

        int res = dfs(i + 1, nums, target, curSum + nums[i]) + dfs(i + 1, nums, target, curSum - nums[i]);
        return memo[i][curSum + offset] = res;
    }
}
