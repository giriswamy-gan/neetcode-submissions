class Solution {
    public int getSum(int a, int b) {
        long i = 1;
        int carry = 0;
        int res = 0;
        while(i < 0x100000000L) {
            if((i & a) != 0 && (i & b) != 0) {
                if(carry == 1) {
                    res |= (int)i;
                }
                carry = 1;
            }
            else if((i & a) != 0 || (i & b) != 0) {
                if(carry != 1) {
                    res |= (int)i;
                }
            }
            else {
                if(carry == 1) {
                    res |= (int)i;
                    carry = 0;
                }
            }
            i *= 2;
        }
        return res;
    }
}
