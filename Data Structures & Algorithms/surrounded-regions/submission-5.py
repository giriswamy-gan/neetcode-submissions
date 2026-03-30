class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS, COLS = len(board), len(board[0])
        q = deque()

        # def check(r, c):
        #     if min(r, c) < 0 or r >= ROWS or c >= COLS or board[r][c] != 'O':
        #         return
        #     board[r][c] = 'T'

        for r in range(ROWS):
            q.append([r, 0])
            q.append([r, COLS - 1])

        for c in range(COLS):
            q.append([0, c])
            q.append([ROWS - 1, c])

        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while q:
            r, c = q.popleft()
            if board[r][c] == 'O':
                board[r][c] = 'T'
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < ROWS and 0 <= nc < COLS and board[nr][nc] == 'O':
                        # board[nr][nc] = 'T'
                        q.append([nr, nc])
        
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == 'T':
                    board[r][c] = 'O'
                elif board[r][c] == 'O':
                    board[r][c] = 'X'
