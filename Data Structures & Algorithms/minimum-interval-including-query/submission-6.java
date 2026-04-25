class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] newQ = Arrays.copyOf(queries, queries.length);
        Arrays.sort(newQ);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;

        for(int q : newQ) {
            while(i < intervals.length && intervals[i][0] <= q) {
                pq.add(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                map.put(q, pq.peek()[0]);
            }
            else {
                map.put(q, -1);
            }
        }
        int[] res = new int[queries.length];
        for(i = 0; i < queries.length; ++i) {
            res[i] = map.get(queries[i]);
        }
        return res;
    }
}
