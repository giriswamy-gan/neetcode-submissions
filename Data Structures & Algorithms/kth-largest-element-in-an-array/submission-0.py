class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        k = len(nums) - k

        def quickSelect(l, r):
            pivot, p = r, l

            for i in range(l, r):
                if nums[pivot] >= nums[i]:
                    nums[p], nums[i] = nums[i], nums[p]
                    p += 1

            nums[r], nums[p] = nums[p], nums[r]

            if p > k: return quickSelect(l, p - 1)
            elif p < k: return quickSelect(p + 1, r)
            else: return nums[p]

        return quickSelect(0, len(nums)-1)
