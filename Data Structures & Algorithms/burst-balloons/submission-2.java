class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = newNums[newNums.length - 1] = 1;
        for(int i = 0; i < nums.length; ++i) {
            newNums[i + 1] = nums[i];
        }

        memo = new int[newNums.length + 1][newNums.length + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(newNums, 1, newNums.length - 2);
    }

    private int dfs(int[] nums, int l, int r) {
        if(l > r) return 0;
        if(memo[l][r] != -1) return memo[l][r];

        int res = 0;
        for(int i = l; i <= r; ++i) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, l, i - 1) + dfs(nums, i + 1, r);
            res = Math.max(res, coins);
        }
        return memo[l][r] = res;
    }
}
