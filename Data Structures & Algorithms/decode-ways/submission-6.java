class Solution {
    Map<Integer, Integer> dp;
    public int numDecodings(String s) {
        dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(0, s);
    }

    private int dfs(int i, String s) {
        if(dp.containsKey(i)) return dp.get(i);
        if(s.charAt(i) == '0') return 0;

        int res = dfs(i + 1, s);
        if(i < s.length() - 1) {
            if(s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7') {
                res += dfs(i + 2, s);
            }
        }
        dp.put(i, res);
        return dp.get(i);
    }
}
