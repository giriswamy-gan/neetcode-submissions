class Solution {
    public int lengthOfLIS(int[] nums) {
        int LIS = 1;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; ++i) {
            if(list.get(list.size() - 1) < nums[i]) {
                list.add(nums[i]);
                LIS++;
                continue;
            }
            int idx = Collections.binarySearch(list, nums[i]);
            if(idx < 0) idx = -idx - 1;
            list.set(idx, nums[i]);
        }
        return LIS;
    }
}
