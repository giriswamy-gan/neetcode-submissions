class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for(int i=0; i<t.length(); ++i) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int matches = 0;
        int resLength = Integer.MAX_VALUE;
        String res = "";
        int l = 0;
        for(int r=0; r<s.length(); ++r) {
            char rIdx = s.charAt(r);
            mapS.put(rIdx, mapS.getOrDefault(rIdx, 0) + 1);
            if(mapT.containsKey(rIdx) && mapS.get(rIdx) == mapT.get(rIdx)) {
                matches++;
            }
            while(matches == mapT.size()) {
                if((r - l + 1) < resLength) {
                    resLength = r - l + 1;
                    res = s.substring(l, r+1);
                }
                char lIdx = s.charAt(l);
                mapS.put(lIdx, mapS.get(lIdx) - 1);
                if(mapT.containsKey(lIdx) && mapS.get(lIdx) < mapT.get(lIdx)) {
                    matches--;
                }
                l++;
            }
        }
        return res;
    }
}
