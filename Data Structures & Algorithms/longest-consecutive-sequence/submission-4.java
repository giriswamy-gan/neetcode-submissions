class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }

        int res = 0;
        for(int i=0; i<nums.length; ++i) {
            int count = 0;
            if(!set.contains(nums[i] - 1)) {
                ++count;
                int cur = nums[i] + 1;
                while(set.contains(cur)) {
                    ++count;
                    ++cur;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
