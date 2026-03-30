class Solution {
    int[] res;
    int longest;

    public String longestPalindrome(String s) {
        res = new int[2];
        longest = 0;

        for(int i = 0; i < s.length(); ++i) {
            helper(s, i - 1, i + 1);
            helper(s, i, i + 1);
        }
        return s.substring(res[0], res[1] + 1);
    }

    private void helper(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if(r - l + 1 > longest) {
                longest = r - l + 1;
                res[0] = l;
                res[1] = r;
            }
            l--;
            r++;
        }
    }
}
