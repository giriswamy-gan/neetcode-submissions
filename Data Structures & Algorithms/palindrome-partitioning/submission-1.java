class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> partition = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0, s);
        return res;
    }

    private void dfs(int i, String s) {
        if(i >= s.length()) {
            res.add(new ArrayList<>(partition));
            return;
        }

        for(int j=i; j<s.length(); ++j) {
            if(isPali(s, i, j)) {
                partition.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

// aab