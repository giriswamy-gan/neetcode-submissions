class Solution {
    public int findKthLargest(int[] nums, int k) {
        return mergeSort(nums, 0, nums.length - 1, k);
    }

    private int mergeSort(int[] nums, int l, int r, int k) {
        int pivot = r;
        int m = l;
        for(int i = l; i < r; ++i) {
            if(nums[i] <= nums[pivot]) {
                int tmp = nums[i];
                nums[i] = nums[m];
                nums[m] = tmp;
                m++;
            }
        }
        int tmp = nums[pivot];
        nums[pivot] = nums[m];
        nums[m] = tmp;

        int target = nums.length - m;
        if(target == k) return nums[m];
        else if(target > k) return mergeSort(nums, m + 1, r, k);
        else return mergeSort(nums, l, m - 1, k);
    }
}
