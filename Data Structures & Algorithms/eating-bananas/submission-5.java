class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int min = 1;

        int res = max;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(check(piles, h, mid)) {
                res = mid;
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        return res;
    }

    private boolean check(int[] piles, int h, int m) {
        long totalHours = 0;
        for(int p : piles) {
            totalHours += Math.ceil((double) p / m);
        }
        return totalHours <= h;
    }
}
