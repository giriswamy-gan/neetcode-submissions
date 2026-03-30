class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while(l <= r) {
            long ans = 0;
            int mid = l + ((r-l)/2);
            for(int pile: piles) {
                ans += (int) Math.ceil((double) pile / mid);
            }
            if(ans<=h && mid < res) {
                res = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return res;
    }
}
