class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        int curMax = 0;
        
        for(int r=0; r<s.length(); ++r) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            curMax = Math.max(curMax, map.get(s.charAt(r)));
            while((r - l + 1) - curMax > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
