class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        while(true) {
            long ans = 0;
            for(int j=0; j<piles.length; ++j) {
                ans = ans + (int) Math.ceil((double) piles[j] / i);
            }
            if(ans<=h) {
                return i;
            }
            i++;
        }
    }
}
