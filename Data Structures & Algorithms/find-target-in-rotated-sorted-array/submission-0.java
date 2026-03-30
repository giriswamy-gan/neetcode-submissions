class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length - 1, res = nums[0], resIndex=0;
        while(l <= r) {
            if(nums[l] < nums[r]) {
                if(nums[l] < res) {
                    res = nums[l];
                    resIndex = l;
                }
                break;
            }
            int m = l + ((r-l)/2);
            if(nums[m] < res) {
                res = nums[m];
                resIndex = m;
            }
            if(nums[m] >= nums[r]) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        l = 0;
        r = nums.length - 1;
        if(target >= nums[resIndex] && target <= nums[r]) {
            l = resIndex;
        }
        else {
            r = resIndex - 1;
        }

        while(l <= r) {
            int m = l + ((r-l)/2);
            if(target < nums[m]) {
                r = m - 1;
            }
            else if(target > nums[m]) {
                l = m + 1;
            }
            else {
                return m;
            }
        }
        return -1;
    }
}
