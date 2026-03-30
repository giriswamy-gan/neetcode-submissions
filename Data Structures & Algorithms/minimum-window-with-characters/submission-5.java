class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int matches = 0;
        int need = map1.size();
        int l = 0;
        int resLen = Integer.MAX_VALUE;
        int[] res = new int[2];
        String output = "";
        for(int r=0; r<s.length(); ++r) {
            char c = s.charAt(r);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            
            if(map1.containsKey(c) && map2.get(c) == map1.get(c)) matches++;
            while(matches == need) {
                if(resLen > (r - l + 1)) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char left = s.charAt(l);
                map2.put(left, map2.get(left) - 1);
                if(map1.containsKey(left) && map2.get(left) < map1.get(left)) {
                    matches--;
                }
                ++l;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}