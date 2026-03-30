class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0, new ArrayList<>(), s);
        return res;
    }

    private void dfs(int i, List<String> cur, String s) {
        if(i == s.length()) {
            res.add(new ArrayList<>(cur));
        }

        for(int j = i; j < s.length(); ++j) {
            if(isPali(s, i, j)) {
                String tmp = s.substring(i, j + 1);
                cur.add(tmp);
                dfs(j + 1, cur, s);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
