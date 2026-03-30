class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        visited = [False] * len(nums)

        def dfs(perm):
            if len(perm) == len(nums):
                res.append(perm.copy())
                return

            for j in range(len(nums)):
                if not visited[j]:
                    perm.append(nums[j])
                    visited[j] = True
                    dfs(perm)
                    visited[j] = False
                    perm.pop()
        
        dfs([])
        return res
