class Solution:
    def myPow(self, x: float, n: int) -> float:
        if x == 0:
            return 0
        if n < 0:
            return 1/self.calc(x, abs(n))
        return self.calc(x, n)

    def calc(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n % 2 == 0:
            return self.calc(x * x, n//2)
        else:
            return x * self.calc(x*x, n//2)
