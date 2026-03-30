class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> ch = new HashSet<>();
        int l = 0, max = 0;
        for(int i=0; i<s.length(); ++i) {
            while(ch.contains(s.charAt(i))) {
                ch.remove(s.charAt(l));
                ++l;
            }
            ch.add(s.charAt(i));
            max = Math.max(max, ch.size());
        }
        return max;
    }
}
