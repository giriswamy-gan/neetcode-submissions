class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] newQ = Arrays.copyOf(queries, queries.length);
        Arrays.sort(newQ);
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        for(int query : newQ) {
            while(i < intervals.length && intervals[i][0] <= query) {
                int size = intervals[i][1] - intervals[i][0] + 1;
                minHeap.add(new int[]{size, intervals[i][1]});
                ++i;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }
            if(!minHeap.isEmpty()) {
                map.put(query, minHeap.peek()[0]);
            }
        }

        int[] res = new int[queries.length];
        for(i = 0; i < queries.length; ++i) {
            res[i] = map.getOrDefault(queries[i], -1);
        }
        return res;
    }
}
