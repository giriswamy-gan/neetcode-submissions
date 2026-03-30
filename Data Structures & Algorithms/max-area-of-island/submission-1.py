class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        ROWS, COLS = len(grid), len(grid[0])
        res = 0
        
        def bfs(r, c):
            q = deque()
            q.append([r, c])
            grid[r][c] = 0
            length = 0
            while q:
                row, col = q.popleft()
                length += 1
                for dr, dc in directions:
                    newRow = row + dr
                    newCol = col + dc
                    if min(newRow, newCol) < 0 or newRow >= ROWS or newCol >= COLS or grid[newRow][newCol] == 0:
                        continue
                    q.append([newRow, newCol])
                    grid[newRow][newCol] = 0
            return length
        
        for row in range(ROWS):
            for col in range(COLS):
                if grid[row][col] == 1:
                    res = max(res, bfs(row, col))
        return res
