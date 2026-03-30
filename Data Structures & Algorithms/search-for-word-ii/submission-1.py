class TrieNode:
    def __init__(self):
        self.children = {}
        self.index = -1

    def insert(self, s, i):
        cur = self
        for c in s:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.index = i

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()
        for i in range(len(words)):
            root.insert(words[i], i)
        
        ROWS = len(board)
        COLS = len(board[0])
        res = []
        
        def dfs(r, c, root):
            if root.index != -1:
                res.append(words[root.index])
                root.index = -1
            if min(r, c) < 0 or r >= ROWS or c >= COLS or board[r][c] == '*' or board[r][c] not in root.children:
                return
            
            tmp = board[r][c]
            board[r][c] = '*'

            dfs(r + 1, c, root.children[tmp])
            dfs(r - 1, c, root.children[tmp])
            dfs(r, c + 1, root.children[tmp])
            dfs(r, c - 1, root.children[tmp])

            board[r][c] = tmp
        
        for row in range(ROWS):
            for col in range(COLS):
                dfs(row, col, root)
        return res
        