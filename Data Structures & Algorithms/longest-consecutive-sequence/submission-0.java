class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int maxLength = 0;
        for(Integer n: set) {
            if(!set.contains(n-1)) {
                int length = 0;
                while(set.contains(n+length)) {
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }
}
