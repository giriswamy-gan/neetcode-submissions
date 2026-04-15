class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] newQ = Arrays.copyOf(queries, queries.length);
        Arrays.sort(newQ);
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for(int query : newQ) {
            while(j < intervals.length && intervals[j][0] <= query) {
                minHeap.add(new int[]{intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                ++j;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }
            if(!minHeap.isEmpty()) {
                map.put(query, minHeap.peek()[0]);
            }
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; ++i) {
            res[i] = map.getOrDefault(queries[i], -1);
        }
        return res;
    }
}