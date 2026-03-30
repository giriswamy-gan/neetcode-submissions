class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        int longest = 0;
        for(int n : nums) {
            int currLongest = 1;
            int cur = n;
            while(set.contains(cur+1)) {
                cur++;
                currLongest++;
            }
            longest = Math.max(longest, currLongest);
        }
        return longest;
    }
}
