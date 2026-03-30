class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length-1, nums.length - k);
    }
    private int quickselect(int[] nums, int l, int r, int target) {
        int pivot = nums[r];
        int p = l;
        for(int i=l; i<r; ++i) {
            if(nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                ++p;
            }
        }
        int temp = nums[r];
        nums[r] = nums[p];
        nums[p] = temp;
        
        if(p == target) {
            return nums[p];
        } else if(p < target) {
            return quickselect(nums, p+1, r, target);
        } else {
            return quickselect(nums, l, p-1, target);
        }
    }
}
