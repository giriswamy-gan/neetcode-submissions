class Solution {
    public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        int res = 0;
        while(x != 0) {
            int digit = x % 10;
            if(res > MAX / 10 || res < MIN / 10 || 
            (res == MAX / 10 && digit > MAX % 10) || 
            (res == MIN / 10 && digit < MIN % 10)) {
                return 0;
            }
            res = res * 10 + digit;
            x = x / 10;
        }
        return res;
    }
}
