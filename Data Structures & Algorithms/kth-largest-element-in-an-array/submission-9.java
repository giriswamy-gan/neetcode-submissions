class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k);
    }

    private int quickselect(int[] nums, int l, int r, int k) {
        int pivot = r;
        int prev = l;
        for(int i=l; i<pivot; ++i) {
            if(nums[i] <= nums[pivot]) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                ++l;
            }
        }
        if(nums.length - l == k) {
            return nums[pivot];
        }
        int temp = nums[pivot];
        nums[pivot] = nums[l];
        nums[l] = temp;
        if(k > nums.length - l) {
            return quickselect(nums, prev, l - 1, k);
        } else {
            return quickselect(nums, l + 1, r, k);
        }
    }
}
