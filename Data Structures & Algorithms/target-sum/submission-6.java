class Solution {
    Map<Integer, Integer>[] memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap[nums.length + 1];
        for(int i = 0; i <= nums.length; ++i) {
            memo[i] = new HashMap<>();
        }
        return dfs(0, target, nums);
    }

    private int dfs(int i, int target, int[] nums) {
        if(i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        System.out.println(i);
        if(memo[i].containsKey(target)) return memo[i].get(target);

        int res = dfs(i + 1, target - nums[i], nums) + dfs(i + 1, target + nums[i], nums);
        memo[i].put(target, res);
        return res;
    }
}