class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i <= nums.length; ++i) {
            res = i ^ res;
        }
        for(int num : nums) {
            res = num ^ res;
        }
        return res;
    }
}