class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map1 = {}
        for i in range(len(nums)):
            t = target - nums[i]
            if t in map1:
                return [map1[t], i]
            map1[nums[i]] = i

        return []