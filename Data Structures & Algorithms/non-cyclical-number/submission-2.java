class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(!seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
            if(n == 1) {
                return true;
            }
        }
        return false;
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
