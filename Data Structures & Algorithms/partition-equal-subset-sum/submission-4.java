class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;

        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int i = nums.length - 1; i >= 0; --i) {
            Set<Integer> nextDp = new HashSet<>();
            for(int j : dp) {
                if(j + nums[i] == target) {
                    return true;
                }
                nextDp.add(j + nums[i]);
                nextDp.add(j);
            }
            dp = nextDp;
        }
        return false;
    }
}
