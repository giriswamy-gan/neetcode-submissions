"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        start = sorted([i.start for i in intervals])
        end = sorted([i.end for i in intervals])
        res = count = 0

        startI = 0
        endI = 0
        
        while startI < len(intervals):
            if start[startI] < end[endI]:
                count += 1
                res = max(count, res)
                startI += 1
            else:
                count -= 1
                endI += 1
        
        return res

