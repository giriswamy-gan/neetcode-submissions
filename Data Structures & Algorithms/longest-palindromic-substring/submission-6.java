class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resLen = 0;
        String res = "";
        for(int i=0; i<n; ++i) {
            for(int j=i; j<n; ++j) {
                int l = i, r = j;
                while(l < r) {
                    if(s.charAt(l) != s.charAt(r)) break;
                    l++;
                    r--;
                }
                if(l >= r && resLen < (j - i + 1)) {
                    res = s.substring(i, j + 1);
                    resLen = j - i + 1;
                }
            }
        }
        return res;
    }
}
