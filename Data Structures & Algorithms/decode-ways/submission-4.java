class Solution {
    int count = 0;
    public int numDecodings(String s) {
        dfs(0, s);
        return count;
    }

    private void dfs(int i, String s) {
        if(i >= s.length()) {
            count++;
        }
        for(int j=i; j<s.length(); ++j) {
            if((j - i + 1) <= 2 && isValid(s, i, j+1)) {
                dfs(j + 1, s);
            }
        }
    }

    private boolean isValid(String s, int l, int r) {
        String tmp = s.substring(l, r);
        if(tmp.charAt(0) == '0') return false;
        int cur = Integer.parseInt(tmp);
        if(cur > 26) return false;
        return true;
    }
}
