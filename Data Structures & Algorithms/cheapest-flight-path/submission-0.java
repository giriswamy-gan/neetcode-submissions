class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0; i<n; ++i) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[2], flight[1]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, src, 0});
        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int cost = cur[0], node = cur[1];
            // System.out.println(cost + " " + node + " " + cur[2]);
            if(cur[1] == dst && cur[2] - 1 <= k) {
                return cost;
            }
            for(int[] nei : adj.get(node)) {
                int neiK = cur[2];
                minHeap.add(new int[]{cost + nei[0], nei[1], ++neiK});
            }
        }
        return -1;
    }
}
