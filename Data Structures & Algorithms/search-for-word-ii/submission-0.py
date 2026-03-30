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
        
        def dfs(row, col, root):
            if root.index != -1:
                res.append(words[root.index])
                root.index = -1
            if min(row, col) < 0 or row >= ROWS or col >= COLS or board[row][col] == '*' or board[row][col] not in root.children:
                return
            
            tmp = board[row][col]
            board[row][col] = '*'

            dfs(row + 1, col, root.children[tmp])
            dfs(row - 1, col, root.children[tmp])
            dfs(row, col + 1, root.children[tmp])
            dfs(row, col - 1, root.children[tmp])

            board[row][col] = tmp
        
        for row in range(ROWS):
            for col in range(COLS):
                dfs(row, col, root)
        return res
        