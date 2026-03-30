class Solution {
    int[][] memo;
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        memo = new int[weight.size()][capacity + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, profit, weight, capacity);
    }

    private int dfs(int i, List<Integer> profit, List<Integer> weight, int capacity) {
        if(i == profit.size()) return 0;
        if(memo[i][capacity] != -1) return memo[i][capacity];

        int res = dfs(i + 1, profit, weight, capacity);
        int newCap = capacity - weight.get(i);
        if(newCap >= 0) {
            int p = profit.get(i) + dfs(i + 1, profit, weight, newCap);
            res = Math.max(res, p);
        }
        return memo[i][capacity] = res;
    }
}
