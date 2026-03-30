class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] visit = new boolean[n][n];
        int count = 0;
        for(int i = 0; i < n; ++i) {
            int l = i, r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(!visit[l][r]) {
                    visit[l][r] = true;
                    count++;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(!visit[l][r]) {
                    visit[l][r] = true;
                    count++;
                }
                l--;
                r++;
            }
        }
        return count;
    }
}
