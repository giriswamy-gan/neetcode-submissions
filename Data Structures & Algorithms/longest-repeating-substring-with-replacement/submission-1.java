class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, res=0, maxf=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int r=0; r<s.length(); ++r) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));
            while((r-l+1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                ++l;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
