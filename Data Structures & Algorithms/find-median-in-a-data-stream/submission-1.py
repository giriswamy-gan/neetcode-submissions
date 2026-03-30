class MedianFinder:

    def __init__(self):
        self.arr = []
        self.median = 0.0

    def addNum(self, num: int) -> None:
        self.arr.append(num)
        self.arr.sort()
        if len(self.arr) % 2 == 0:
            r = len(self.arr) // 2
            l = r - 1
            self.median = (self.arr[l] + self.arr[r]) / 2
        else:
            self.median = self.arr[len(self.arr) // 2]

    def findMedian(self) -> float:
        return self.median
        