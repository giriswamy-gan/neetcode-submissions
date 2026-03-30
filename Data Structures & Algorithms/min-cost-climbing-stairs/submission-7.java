class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        int a = 0, b = 0, c = 0;
        for(int i = cost.length - 1; i >= 0; --i) {
            a = cost[i] + Math.min(b, c);
            c = b;
            b = a;
        }
        return Math.min(a, c);
    }
}
