class Solution {
    int[][] memo;
    int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();
        memo = new int[nums.length][totalSum * 2 + 1];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int curSum, int[] nums, int target) {
        if(i == nums.length) {
            if(curSum == target) return 1;
            else return 0;
        }
        if(memo[i][curSum + totalSum] != Integer.MIN_VALUE) return memo[i][curSum + totalSum];

        return memo[i][curSum + totalSum] = dfs(i + 1, curSum - nums[i], nums, target) + dfs(i + 1, curSum + nums[i], nums, target);
    }
}
