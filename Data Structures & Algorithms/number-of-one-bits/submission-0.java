class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; ++i) {
            int pow = 1 << i;
            count += (pow & n) > 0 ? 1 : 0;
        }
        return count;
    }
}
