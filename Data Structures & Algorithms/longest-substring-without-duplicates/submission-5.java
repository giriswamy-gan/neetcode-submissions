class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int l = 0;

        for(int r=0; r<s.length(); ++r) {
            if(map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
