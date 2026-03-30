class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length-2; ++i) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int cur = nums[i] + nums[j] + nums[k];
                if(cur == 0) {
                    List<Integer> tempRes = new ArrayList<>();
                    tempRes.add(nums[i]);
                    tempRes.add(nums[j]);
                    tempRes.add(nums[k]);
                    res.add(tempRes);
                    while(j < k && nums[j] == nums[j+1]) {
                        ++j;
                    }
                    while(j < k && nums[k] == nums[k-1]) {
                        --k;
                    }
                    ++j;
                    --k;
                }
                else if(cur > 0) {
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
