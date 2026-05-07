class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int i = 0;
        int jumps = 0;
        while(maxJump < (nums.length - 1)) {
            int curJump = i;
            int j = 0;
            for(j = i; j <= maxJump; ++j) {
                curJump = Math.max(curJump, j + nums[j]);
            }
            maxJump = Math.max(maxJump, curJump);
            i = j;
            jumps++;
        }
        return jumps;
    }
}
