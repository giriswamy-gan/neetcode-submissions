class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while(l <= r) {
            int m = l + ((r-l)/2);
            if(nums[m] == target) {
                return m;
            }
            else if(nums[m] >= nums[l]) {
                if(nums[l] <= target && nums[m] >= target) {
                    r = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
            else {
                if(nums[r] >= target && nums[m] <= target) {
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}

// [5,1,3]
//  l m r

// [4,5,6,7,0,1,2]
//          l m r

// [3,5,6,0,1,2]
//    l t   m r