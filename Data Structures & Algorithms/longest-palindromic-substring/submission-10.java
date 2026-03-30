class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resLen = 1;
        int resIdx = 0;
        for(int i=1; i<n; ++i) {
            // odd
            int l = i - 1, r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    resIdx = l;
                }
                l--;
                r++;
            }

            // even
            l = i - 1;
            r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    resIdx = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
}
