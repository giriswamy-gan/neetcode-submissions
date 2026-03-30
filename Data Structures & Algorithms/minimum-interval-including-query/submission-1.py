class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        queries_sorted = sorted(enumerate(queries), key=lambda x:x[1])
        intervals.sort(key=lambda x:x[0])

        res = [-1] * len(queries)

        for index, query in queries_sorted:
            minRes = float('inf')
            for i in range(len(intervals)):
                if intervals[i][0] <= query and query <= intervals[i][1]:
                    minRes = min(intervals[i][1] - intervals[i][0] + 1, minRes)
            res[index] = minRes if minRes != float('inf') else -1

        return res
