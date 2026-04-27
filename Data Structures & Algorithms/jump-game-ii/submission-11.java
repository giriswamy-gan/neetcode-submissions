class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int i = 1;
        int res = 1;
        int maxJump = nums[0];
        while(maxJump < nums.length - 1) {
            int tmpJump = maxJump;
            int j = 0;
            for(j = i; j <= maxJump && j < nums.length; ++j) {
                tmpJump = Math.max(tmpJump, j + nums[j]);
            }
            i = j;
            maxJump = tmpJump;
            res++;
        }
        return res;
    }
}
