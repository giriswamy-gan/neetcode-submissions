class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int r = n-1;
        int l = 0;
        int res = 1001;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
