class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int prev = intervals[0][1];

        for(int i = 1; i < intervals.length; ++i) {
            if(prev < intervals[i][0]) {
                res.add(intervals[i]);
                prev = intervals[i][1];
            }
            else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
                prev = res.get(res.size() - 1)[1];
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
