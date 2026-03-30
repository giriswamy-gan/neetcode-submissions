class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        cache = [-1] * len(nums)
        
        return max(self.dfs(0, nums[:-1], [-1] * len(nums)), self.dfs(0, nums[1:], [-1] * len(nums)))
    
    def dfs(self, i, nums, cache):
        if i >= len(nums):
            return 0
        if cache[i] != -1:
            return cache[i]
        cache[i] = max(nums[i] + self.dfs(i+2, nums, cache), self.dfs(i+1, nums, cache))
        return cache[i]
    
# [2,9,8,3,6]