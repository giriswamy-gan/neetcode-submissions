class Solution {
    Set<Integer> pos = new HashSet<>();
    Set<Integer> neg = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }

        dfs(0, n, board);
        return res;
    }

    private void dfs(int r, int n, char[][] board) {
        if(r == n) {
            List<String> copy = new ArrayList<>();
            for(char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c=0; c<board[0].length; ++c) {
            if(col.contains(c) || pos.contains(r + c) || neg.contains(r - c)) {
                continue;
            }
            col.add(c);
            pos.add(r + c);
            neg.add(r - c);
            board[r][c] = 'Q';

            dfs(r + 1, n, board);

            col.remove(c);
            pos.remove(r + c);
            neg.remove(r - c);
            board[r][c] = '.';
        }
    }
}
