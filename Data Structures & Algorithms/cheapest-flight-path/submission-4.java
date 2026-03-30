class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int p = cur[0], s = cur[1], stops = cur[2];
            if(stops > k) continue;
            for(int[] neighbor : adj.get(s)) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCst = p + w;
                if(nextCst < prices[nei]) {
                    prices[nei] = nextCst;
                    q.add(new int[]{nextCst, nei, stops + 1});
                }
            }
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
