class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(int i=0; i<n; ++i) {
            Arrays.fill(board[i], '.');
        }
        dfs(0, n);
        return res;
    }

    private void dfs(int r, int n) {
        if(r == n) {
            List<String> copy = new ArrayList<>();
            for(char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }
        
        for(int c=0; c<n; ++c) {
            if(posDiag.contains(r+c) || negDiag.contains(r-c) || cols.contains(c)) {
                continue;
            }
            board[r][c] = 'Q';
            posDiag.add(r+c);
            negDiag.add(r-c);
            cols.add(c);

            dfs(r + 1, n);
            
            board[r][c] = '.';
            posDiag.remove(r+c);
            negDiag.remove(r-c);
            cols.remove(c);
        }
    }
}
