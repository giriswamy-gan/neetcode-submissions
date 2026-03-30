class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return quicksort(nums, 0, nums.length - 1, target);
    }

    private int quicksort(int[] nums, int l, int r, int targetIdx) {
        int p = r;
        int idx = l;
        for(int i=l; i<r; ++i) {
            if(nums[i] <= nums[p]) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
                idx++;
            }
        }
        int tmp = nums[p];
        nums[p] = nums[idx];
        nums[idx] = tmp;
        
        if(idx == targetIdx) {
            return nums[idx];
        }
        else if(idx > targetIdx) {
            return quicksort(nums, l, idx - 1, targetIdx);
        }
        else {
            return quicksort(nums, idx + 1, r, targetIdx);
        }
    }
}

// [5,2,4,1,3,6,0]
// [0,2,4,1,3,6,5]
// [0,2,4,1,3,5,6]
// [0,2,3,1,4]

// [0,1,2,3,4,5,6]


