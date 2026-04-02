class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] interval : intervals) {
            int[] curInterval = null;
            if(res.size() > 0) {
                curInterval = res.get(res.size() - 1);
            }
            if(res.size() == 0 || interval[1] < curInterval[0] || interval[0] > curInterval[1]) {
                res.add(interval);
            }
            else {
                res.get(res.size() - 1)[0] = Math.min(curInterval[0], interval[0]);
                res.get(res.size() - 1)[1] = Math.max(curInterval[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
