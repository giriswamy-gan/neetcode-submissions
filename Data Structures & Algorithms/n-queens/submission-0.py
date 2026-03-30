class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols = set()
        posDiag = set()
        negDiag = set()

        board = [["."] * n for i in range(n)]
        res = []

        def dfs(r):
            if r == n:
                copy = ["".join(row) for row in board]
                res.append(copy)
                return
            for c in range(n):
                if c in cols or (r-c) in negDiag or (r+c) in posDiag:
                    continue
                board[r][c] = 'Q'
                cols.add(c)
                negDiag.add(r-c)
                posDiag.add(r+c)

                dfs(r + 1)

                board[r][c] = '.'
                cols.remove(c)
                negDiag.remove(r-c)
                posDiag.remove(r+c)

        dfs(0)
        return res
