class Solution {
    int[][] memo;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        memo = new int[nums.length + 1][total * 2 + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, nums, target, 0);
    }

    private int dfs(int i, int[] nums, int target, int curSum) {
        if(i == nums.length) return curSum == target ? 1 : 0;
        if(memo[i][curSum + total] != -1) return memo[i][curSum + total];
        int res = dfs(i + 1, nums, target, curSum - nums[i]) + dfs(i + 1, nums, target, curSum + nums[i]);
        return memo[i][curSum + total] = res;
    }
}
