class Solution:
    def climbStairs(self, n: int) -> int:
        return self.dfs(1, n) + self.dfs(2, n)
    
    def dfs(self, length : int, n : int) -> int:
        if length > n:
            return 0
        if length == n:
            return 1
        res = 0
        for i in range(1, 3):
            res += self.dfs(length + i, n)
        return res
