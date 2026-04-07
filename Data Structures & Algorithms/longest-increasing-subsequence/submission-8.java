class Solution {
    public int lengthOfLIS(int[] nums) {
        int LIS = 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for(int i = 1; i < nums.length; ++i) {
            if(dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
                LIS++;
                continue;
            }

            int idx = Collections.binarySearch(dp, nums[i]);
            if(idx < 0) idx = -idx - 1;
            dp.set(idx, nums[i]);
        }
        return LIS;
    }
}
