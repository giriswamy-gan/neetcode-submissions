class Solution {
    int[] memo;
    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dfs(0, nums);
    }

    private int dfs(int i, int[] nums) {
        if(i == nums.length - 1) return 0;
        if(memo[i] != -1) return memo[i];

        int end = Math.min(nums.length - 1, i + nums[i]);
        int res = (int) 1e6;
        for(int j = i + 1; j <= end; ++j) {
            res = Math.min(res, 1 + dfs(j, nums));
        }
        return memo[i] = res;
    }
}
