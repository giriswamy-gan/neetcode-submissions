class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        while(true) {
            while(n != 0) {
                int rem = n % 10;
                n = n / 10;
                sum += rem * rem;
            }
            if(sum == 1) {
                return true;
            }
            if(seen.contains(sum)) {
                return false;
            }
            seen.add(sum);
            n = sum;
            sum = 0;
        }
    }
}
