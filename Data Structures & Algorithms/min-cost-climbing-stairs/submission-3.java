class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = cost[cost.length - 1];
        for(int i = cost.length - 2; i >= 0; --i) {
            cost[i] = cost[i] + Math.min(a, b);
            a = b;
            b = cost[i];
        }
        return Math.min(a, b);
    }
}
