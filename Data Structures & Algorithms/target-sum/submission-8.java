class Solution {
    int[][] memo;
    int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();
        memo = new int[nums.length + 1][totalSum * 2 + 1];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int total, int[] nums, int target) {
        if(i == nums.length) {
            return total == target ? 1 : 0;
        }
        if(memo[i][total + totalSum] != Integer.MIN_VALUE) return memo[i][total + totalSum];

        int res = dfs(i + 1, total - nums[i], nums, target) + dfs(i + 1, total + nums[i], nums, target);
        return memo[i][total + totalSum] = res;
    }
}