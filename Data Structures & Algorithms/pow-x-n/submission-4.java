class Solution {
    public double myPow(double x, int n) {
        return n > 0 ? helper(x, n) : 1 / helper(x, -1 * n);
    }

    private double helper(double x, int n) {
        if(n == 1) return x;
        if(n == 0) return 1;

        double prod = helper(x, n / 2);
        return n % 2 == 0 ? prod * prod : x * prod * prod;
    }
}
