class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int res = 0;

        for(int i = 1; i < intervals.length; ++i) {
            if(prevEnd <= intervals[i][0]) {
                prevEnd = intervals[i][1];
            }
            else {
                res++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
        }
        return res;
    }
}
