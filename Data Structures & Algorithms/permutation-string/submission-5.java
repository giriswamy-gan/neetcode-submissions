class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(int i=0; i<s1.length(); ++i) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        int match = 0;
        for(int i=0; i<26; ++i) {
            if(s1Map[i] == s2Map[i]) match++;
        }

        if(match == 26) return true;

        int i = 0;
        for(int j=s1.length(); j<s2.length(); ++j) {
            if(match == 26) {
                return true;
            }

            int r = s2.charAt(j) - 'a';
            s2Map[r]++;
            if(s2Map[r] == s1Map[r]) {
                match++;
            } else if(s2Map[r] - 1 == s1Map[r]) {
                match--;
            }

            int l = s2.charAt(i) - 'a';
            s2Map[l]--;
            if(s2Map[l] + 1 == s1Map[l]) {
                match--;
            } else if(s2Map[l] == s1Map[l]) {
                match++;
            }
            ++i;
        }
        System.out.println(match);
        return match == 26;
    }
}
