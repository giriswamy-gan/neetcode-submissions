class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        for(int i=0; i<nums.length; ++i) {
            if(!set.contains(nums[i] - 1)) {
                int num = nums[i];
                longest = 1;
                while(set.contains(num + 1)) {
                    longest++;
                    num++;
                }
            }
            res = Math.max(res, longest);
        }
        return res;
    }
}
