class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(int n, int openN, int closeN, StringBuilder cur) {
        if(cur.length() == n * 2) {
            if(openN == n && closeN == n) {
                // System.out.println(cur.toString());
                String tmp = cur.toString();
                res.add(tmp);
                return;
            } else {
                return;
            }
        }
        if(openN < n) {
            cur.append("(");
            dfs(n, openN + 1, closeN, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(closeN < openN) {
            cur.append(")");
            dfs(n, openN, closeN + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
