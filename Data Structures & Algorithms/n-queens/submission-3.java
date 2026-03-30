class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    Set<Integer> colSet = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] b : board) {
            Arrays.fill(b, '.');
        }

        dfs(0, board);
        return res;
    }

    private void dfs(int r, char[][] board) {
        if(r >= board.length) {
            System.out.println("REACHED");
            List<String> tmp = new ArrayList<>();
            for(char[] b : board) {
                tmp.add(new String(b));
            }
            res.add(tmp);
        }

        for(int c = 0; c < board.length; ++c) {
            if(!colSet.contains(c) && !posDiag.contains(r + c) && 
               !negDiag.contains(r - c)) {
                colSet.add(c);
                posDiag.add(r + c);
                negDiag.add(r - c);
                board[r][c] = 'Q';

                dfs(r + 1, board);

                colSet.remove(c);
                posDiag.remove(r + c);
                negDiag.remove(r - c);
                board[r][c] = '.';
            } 
        }
    }
}
