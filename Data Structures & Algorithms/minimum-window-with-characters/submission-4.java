class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> freqT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i=0; i<t.length(); ++i) {
            freqT.put(t.charAt(i), freqT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int need = freqT.size(), have = 0;
        int l = 0, length = Integer.MAX_VALUE, minL = 0, minR = 0;
        for(int r=0; r<s.length(); ++r) {
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            if(window.get(s.charAt(r)) == freqT.getOrDefault(s.charAt(r), 0)) {
                have++;
            }
            while(have == need) {
                if((r-l+1) < length) {
                    length = r-l+1;
                    minL = l;
                    minR = r;
                }

                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if(window.get(s.charAt(l)) < freqT.getOrDefault(s.charAt(l), 0)) {
                    have--;
                }
                l++;
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(minL, minR+1);
    }
}

// have < need {
//     if character frequencies are equal {
//         increase have
//     }
// }

// while(have == need) {
//     store the length if new length is less than old length
//     start increasing l
//     if character frequency of removed l no longer matches
//     decrease have
// }

