class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])
        visited = set()
        
        def dfs(r, c, idx):
            if idx == len(word):
                return True
            if r >= ROWS or c >= COLS or min(r, c) < 0 or board[r][c] != word[idx] or (r, c) in visited:
                return False
            visited.add((r, c))
            res = dfs(r+1, c, idx+1) or dfs(r, c+1, idx+1) or dfs(r-1, c, idx+1) or dfs(r, c-1, idx+1)
            visited.remove((r, c))
            return res

        for r in range(ROWS):
            for c in range(COLS):
                if dfs(r,c,0):
                    return True
        return False 
