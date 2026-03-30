class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resLen = 0;
        int[] res = {0, 0};
        for(int i=1; i<n; ++i) {
            System.out.println(i);
            int lIdx = i, rIdx = i;
            // odd
            int l = i - 1, r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                lIdx = l;
                rIdx = r;
                l--;
                r++;
            }
            if(rIdx - lIdx + 1 > resLen) {
                resLen = rIdx - lIdx + 1;
                res[0] = lIdx;
                res[1] = rIdx;
            }

            // even
            if(s.charAt(i-1) == s.charAt(i)) {
                lIdx = i - 1;
                rIdx = i;
                l = i - 2;
                r = i + 1;
                while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    lIdx = l;
                    rIdx = r;
                    l--;
                    r++;
                }
            }
            if(rIdx - lIdx + 1 > resLen) {
                resLen = rIdx - lIdx + 1;
                res[0] = lIdx;
                res[1] = rIdx;
            }
        }
        return s.substring(res[0], res[1] + 1);
    }
}
