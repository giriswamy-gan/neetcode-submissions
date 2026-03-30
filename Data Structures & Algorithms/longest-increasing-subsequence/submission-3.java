class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        for(int i=0; i<n; ++i) {
            LIS[i] = 1;
        }

        for(int i = nums.length - 2; i >= 0; --i) {
            for(int j = i + 1; j < nums.length; ++j) {
                if(nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }
        return Arrays.stream(LIS).max().getAsInt();
    }
}
