class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dfs(0, cost), dfs(1, cost));
    }

    private int dfs(int i, int[] cost) {
        if(i >= cost.length) return 0;
        if(memo[i] != -1) return memo[i];
        return memo[i] = cost[i] + Math.min(dfs(i + 1, cost), dfs(i + 2, cost));
    }
}
