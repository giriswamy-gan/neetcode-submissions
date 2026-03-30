class Solution {
    List<String> res = new ArrayList<>();
    String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        dfs(0, new StringBuilder(), digits);
        return res;
    }

    private void dfs(int i, StringBuilder cur, String digits) {
        if(cur.length() == digits.length()) {
            res.add(cur.toString());
            return;
        }

        // System.out.println(digitToChar[digits.charAt(i) - '0']);
        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char ch : chars.toCharArray()) {
            cur.append(ch);
            dfs(i + 1, cur, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
