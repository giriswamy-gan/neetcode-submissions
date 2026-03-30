class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for(int num : nums) {
            Map<Integer, Integer> cur = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                cur.put(total + num, cur.getOrDefault(total + num, 0) + count);
                cur.put(total - num, cur.getOrDefault(total - num, 0) + count);
            }
            dp = cur;
        }

        return dp.getOrDefault(target, 0);
    }
}
