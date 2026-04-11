class Solution {
    public int reverseBits(int n) {
        if(n == 0) return 0;
        int res = 0;
        for(int i = 0; i < 32; ++i) {
            if((n >> i & 1) == 1) {
                res |= (1 << (31 - i));
            }
        }
        return res;
    }
}
