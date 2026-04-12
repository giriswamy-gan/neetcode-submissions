class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] curInterval = intervals[0];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; ++i) {
            if(curInterval[1] < intervals[i][0]) {
                list.add(curInterval);
                curInterval = intervals[i];
            }
            else {
                curInterval[1] = Math.max(curInterval[1], intervals[i][1]);
            }
        }
        list.add(curInterval);
        return list.toArray(new int[list.size()][]);
    }
}
