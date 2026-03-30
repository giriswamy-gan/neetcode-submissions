class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        int newslow = 0;
        while(newslow != slow) {
            newslow = nums[newslow];
            slow = nums[slow];
        }

        return newslow;
    }
}
