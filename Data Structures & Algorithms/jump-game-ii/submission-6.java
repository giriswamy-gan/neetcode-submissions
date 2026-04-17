class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int res = 1;
        int start = 1;
        int maxJump = nums[0];
        while(maxJump < nums.length - 1) {
            int i = 0;
            int curMax = maxJump;
            for(i = start; i <= maxJump && i < nums.length; ++i) {
                curMax = Math.max(curMax, i + nums[i]);
            }
            maxJump = curMax;
            start = i;
            res++;
        }
        return res;
    }
}
