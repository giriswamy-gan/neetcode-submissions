class Solution {
    public boolean canJump(int[] nums) {
        return dfs(0, nums);
    }

    private boolean dfs(int i, int[] nums) {
        if(i == nums.length - 1) return true;

        for(int j = i + 1; j <= i + nums[i]; ++j) {
            if(dfs(j, nums)) return true;
        }
        return false;
    }
}
