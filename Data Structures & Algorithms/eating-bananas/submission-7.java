class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = Integer.MAX_VALUE;
        int maxSpeed = Integer.MIN_VALUE;
        for(int p : piles) {
            if(p < minSpeed) minSpeed = p;
            if(p > maxSpeed) maxSpeed = p;
        }
        int l = 1;
        int r = maxSpeed;
        int res = maxSpeed;
        while(l <= r) {
            int m = (l + r) / 2;
            if(possible(piles, m, h)) {
                res = Math.min(res, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    private boolean possible(int[] piles, int h, int target) {
        int time = 0;
        for(int p : piles) {
            time += Math.ceil((double) p / h);
        }
        return time <= target;
    }
}
