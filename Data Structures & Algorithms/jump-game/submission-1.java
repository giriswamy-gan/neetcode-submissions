class Solution {
    Boolean[] memo;
    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return dfs(0, nums);
    }

    private boolean dfs(int i, int[] nums) {
        if(i == nums.length - 1) return true;
        if(memo[i] != null) return memo[i];

        for(int j = i + 1; j <= i + nums[i]; ++j) {
            if(dfs(j, nums)) {
                memo[i] = true;
                return memo[i];
            }
        }
        memo[i] = false;
        return memo[i];
    }
}
