class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        else if(n > 0) return posPow(x, n);
        else return negPow(x, n);
    }

    private double posPow(double x, int n) {
        if(n == 1) return x;
        return x * posPow(x, n - 1);
    }

    private double negPow(double x, int n) {
        if(n == -1) return 1 / x;
        return (1 / x) * negPow(x, n + 1);
    }
}
