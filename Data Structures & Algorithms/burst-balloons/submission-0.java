class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = newNums[nums.length + 1] = 1;
        for(int i = 0; i < nums.length; ++i) {
            newNums[i + 1] = nums[i];
        }

        dp = new int[newNums.length][newNums.length];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(1, nums.length, newNums);
    }

    private int dfs(int l, int r, int[] nums) {
        if(l > r) return 0;
        if(dp[l][r] != -1) return dp[l][r];

        dp[l][r] = 0;
        for(int i = l; i <= r; ++i) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(l, i - 1, nums) + dfs(i + 1, r, nums);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
}
