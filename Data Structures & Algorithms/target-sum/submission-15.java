class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer>[] dp = new HashMap[nums.length + 1];
        for(int i = 0; i < dp.length; ++i) {
            dp[i] = new HashMap<>();
        }
        dp[0].put(0, 1);
        for(int i = 0; i < nums.length; ++i) {
            for(Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                int curSum = entry.getKey();
                int count = entry.getValue();

                dp[i + 1].put(curSum + nums[i], dp[i + 1].getOrDefault(curSum + nums[i], 0) + count);
                dp[i + 1].put(curSum - nums[i], dp[i + 1].getOrDefault(curSum - nums[i], 0) + count);
            }
        }
        return dp[nums.length].getOrDefault(target, 0);
    }
}
