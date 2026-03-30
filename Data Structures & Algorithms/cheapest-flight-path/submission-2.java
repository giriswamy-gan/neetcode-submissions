class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2], 0});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, src, -1});
        boolean[] visit = new boolean[n];
        visit[src] = true;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int w = cur[0], node = cur[1], stops = cur[2];
            if(node == dst && stops <= k) {
                return w;
            }
            for(int[] nei : adj.get(node)) {
                int newW = nei[1], neiNode = nei[0];
                pq.add(new int[]{w + newW, neiNode, stops + 1});
            }
        }
        return -1;
    }
}
