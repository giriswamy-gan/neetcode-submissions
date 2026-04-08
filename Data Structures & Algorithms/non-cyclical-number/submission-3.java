class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = sumOfSquares(n);
        while(slow != fast) {
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
            
            if(fast == 1) return true;
        }
        return fast == 1;
    }

    private int sumOfSquares(int n) {
        int output = 0;

        while(n != 0) {
            int rem = n % 10;
            output += rem * rem;
            n /= 10;
        }

        return output;
    }
}
