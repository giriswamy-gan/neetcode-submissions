class Solution {
    String[] digitList = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        dfs(0, new StringBuilder(), digits);
        return res;
    }

    private void dfs(int i, StringBuilder cur, String digits) {
        if(i == digits.length()) {
            res.add(cur.toString());
            return;
        }
        int idx = digits.charAt(i) - '0';
        String digit = digitList[idx];
        for(int j=0; j<digit.length(); ++j) {
            cur.append(digit.charAt(j));
            dfs(i + 1, cur, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
