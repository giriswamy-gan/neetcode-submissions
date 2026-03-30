class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        comb = []
        # sum = 0

        def dfs(i):
            if i  >= len(nums) or sum(comb) > target:
                return
            if sum(comb) == target:
                res.append(comb[:])
                return
            comb.append(nums[i])
            dfs(i)

            comb.pop()
            dfs(i + 1)
        
        dfs(0)
        return res
