class Solution:
    def rob(self, nums: List[int]) -> int:
        p1 = 0
        p2 = 0
        for n in nums:
            temp = p2
            p2 = max(p1 + n, p2)
            p1 = temp
        return p2
