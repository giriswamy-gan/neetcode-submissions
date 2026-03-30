class Solution {
    private boolean valid(String s) {
        int add = 0;
        for(char c: s.toCharArray()) {
            add += c == '(' ? 1 : -1;
            if(add < 0) return false;
        }
        return add == 0;
    }

    private void dfs(String s, List<String> res, int n) {
        if(s.length() == n * 2) {
            if(valid(s)) res.add(s);
            return;
        }
        dfs(s + '(', res, n);
        dfs(s + ')', res, n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, n);
        return res;
    }
}
