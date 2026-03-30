class Solution {
    private void backTracking(int openN, int closeN, StringBuilder s, List<String> res, int n) {
        if(openN == closeN && openN == n) {
            res.add(s.toString());
            return;
        }
        if(openN < n) {
            s.append("(");
            backTracking(openN + 1, closeN, s, res, n);
            s.deleteCharAt(s.length() - 1);
        }
        if(closeN < openN) {
            s.append(")");
            backTracking(openN, closeN + 1, s, res, n);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int openN = 0, closeN = 0;
        StringBuilder s = new StringBuilder("");
        backTracking(openN, closeN, s, res, n);
        return res;
    }
}


// start with open paranetheses
// if open > close then add close paranthesis otherwise open paranthesis (as long as its <= n)
