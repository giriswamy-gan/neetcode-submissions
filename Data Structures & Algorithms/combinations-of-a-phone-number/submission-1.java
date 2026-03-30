class Solution {
    List<String> res;
    String[] digitsToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        res = new ArrayList<>();
        dfs(0, "", digits);
        return res;
    }

    private void dfs(int i, String cur, String digits) {
        if(cur.length() == digits.length()) {
            res.add(cur);
            return;
        }
        String chars = digitsToChar[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()) {
            dfs(i + 1, cur + c, digits);
        }
    }
}
