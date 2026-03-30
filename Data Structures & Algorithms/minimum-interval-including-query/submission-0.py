class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        # queries.sort()
        intervals.sort(key=lambda x:x[0])

        res = [-1] * len(queries)
        prev_end = 0
        index = 0

        for j in range(len(queries)):
            minRes = float('inf')
            for i in range(len(intervals)):
                if intervals[i][0] <= queries[j] and queries[j] <= intervals[i][1]:
                    minRes = min(intervals[i][1] - intervals[i][0] + 1, minRes)
            res[j] = minRes if minRes != float('inf') else -1

        return res
