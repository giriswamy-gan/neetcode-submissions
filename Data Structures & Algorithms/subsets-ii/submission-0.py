class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        nums.sort()
        hashSet = set()

        def dfs(i):
            if i == len(nums):
                if tuple(subset) not in hashSet:
                    hashSet.add(tuple(subset))
                    res.append(subset[:])
                return
            subset.append(nums[i])
            dfs(i + 1)

            subset.pop()
            # while i+1 < len(subset) and nums[i] == nums[i+1]:
            #     i += 1
            dfs(i + 1)
        dfs(0)
        return res
