class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        visited = set()
        total = 0

        def dfs(r, c):
            if min(r, c) < 0 or r >= ROWS or c >= COLS or (r, c) in visited or grid[r][c] == "0":
                return
            # if grid[r][c] == 1:
            #     print(visited)
            visited.add((r, c))
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
            return

        for row in range(ROWS):
            for col in range(COLS):
                if (row, col) not in visited and grid[row][col] != "0":
                    dfs(row, col)
                    total += 1
        return total
