class MedianFinder:

    def __init__(self):
        self.leftHeap = []
        self.rightHeap = []
        self.median = 0.0

    def addNum(self, num: int) -> None:
        if self.rightHeap and num > self.rightHeap[0]:
            heapq.heappush(self.rightHeap, num)
        else:
            heapq.heappush(self.leftHeap, -(num))
        
        if len(self.rightHeap) > len(self.leftHeap) + 1:
            val = heapq.heappop(self.rightHeap)
            heapq.heappush(self.leftHeap, -(val))
        if len(self.leftHeap) > len(self.rightHeap) + 1:
            val = heapq.heappop(self.leftHeap)
            heapq.heappush(self.rightHeap, -(val))

    def findMedian(self) -> float:
        if len(self.leftHeap) == len(self.rightHeap):
            val1 = -(self.leftHeap[0])
            val2 = self.rightHeap[0]
            return (val1 + val2) / 2
        elif len(self.leftHeap) > len(self.rightHeap):
            return -(self.leftHeap[0])
        else:
            return self.rightHeap[0]
        