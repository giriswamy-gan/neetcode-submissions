class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        res = []
        prev_end = -1

        for start, end in intervals:
            if prev_end < start:
                prev_end = end
                res.append([start, end])
            else:
                res[-1][1] = max(res[-1][1], end)
                prev_end = res[-1][1]
        
        return res
