class Solution {
    int[] memo;
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        memo = new int[intervals.length];
        Arrays.fill(memo, -1);

        return intervals.length - dfs(intervals, 0);
    }

    private int dfs(int[][] intervals, int i) {
        if(i == intervals.length) return 0;
        if(memo[i] != -1) return memo[i];

        int res = 1;
        for(int j = i + 1; j < intervals.length; ++j) {
            if(intervals[i][1] <= intervals[j][0]) {
                res = Math.max(res, 1 + dfs(intervals, j));
            }
        }

        return memo[i] = res;
    }
}

// [1, 11] [2, 12] [11, 22] [1, 100]
