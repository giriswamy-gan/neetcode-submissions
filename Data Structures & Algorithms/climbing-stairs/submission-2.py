class Solution:
    def climbStairs(self, n: int) -> int:
        p1 = 0
        p2 = 1
        for i in range(n):
            temp = p2
            p2 = p1 + p2
            p1 = temp
        return p2
