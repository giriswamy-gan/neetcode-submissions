class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; ++i) {
            while(i > 0 && i < nums.length - 2 && nums[i-1] == nums[i]) i++;
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
                    while(k > j && nums[k] == nums[k-1]) {
                        --k;
                    }
                    j++;
                    k--;
                } else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}

// [-4, -1, -1, 0, 1, 2]
