class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def helper(i):
            if i == len(nums):
                return [[]]
            perm = helper(i+1)
            resPerm = []

            for p in perm:
                for j in range(len(p) + 1):
                    pcopy = p.copy()
                    pcopy.insert(j, nums[i])
                    resPerm.append(pcopy)
            return resPerm
        return helper(0)
