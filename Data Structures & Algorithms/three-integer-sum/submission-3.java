class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 2; ++i) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    while(j < k && nums[j] == nums[j+1]) {
                        ++j;
                    }
                    while(j < k && nums[k] == nums[k-1]) {
                        --k;
                    }
                    ++j;
                    --k;
                }
                else if(sum > 0) {
                    --k;
                }
                else {
                    ++j;
                }
            }
        }
        return res;
    }
}

// pointer left starting at 0
// pointer right at n - 1;
// start 2 for loops second loop will search for l + r + k == target
// if 
