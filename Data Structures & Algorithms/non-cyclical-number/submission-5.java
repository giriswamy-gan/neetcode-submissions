class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        if(fast == 1) return true;
        while(slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
            if(fast == 1) return true;
        }
        return false;
    }

    private int sumOfSquares(int n) {
        int res = 0;
        while(n > 0) {
            int digit = n % 10;
            n = n / 10;
            res += digit * digit;
        }
        return res;
    }
}
