class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        return max(self.dfs(nums[:-1]), self.dfs(nums[1:]))
    
    def dfs(self, nums):
        p1, p2 = 0, 0

        for n in nums:
            temp = max(p1 + n, p2)
            p1 = p2
            p2 = temp
        return p2
    
# [2,9,8,3,6]