class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, res=0, majority=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int r=0; r<s.length(); ++r) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            majority = Math.max(majority, map.get(s.charAt(r)));
            if((r-l+1) - majority <= k) {
                res = Math.max(res, r-l+1);
            }
            else {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                ++l;
            }
        }
        return res;
    }
}
