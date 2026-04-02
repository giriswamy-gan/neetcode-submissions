class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 1) return 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i = 0; i < points.length; ++i) {
            for(int j = 0; j < points.length; ++j) {
                if(i == j) continue;
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                adj.putIfAbsent(i, new ArrayList<>());
                adj.get(i).add(new int[]{dist, j});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[] visit = new boolean[points.length];
        pq.add(new int[]{0, 0});
        int res = 0;
        int edges = 0;
        while(!pq.isEmpty() && edges <= points.length - 1) {
            int[] cur = pq.poll();
            int dist = cur[0], idx = cur[1];
            if(visit[idx]) continue;
            visit[idx] = true;
            res += dist;
            edges++;
            for(int[] neighbor : adj.get(idx)) {
                int newDist = neighbor[0], nei = neighbor[1];
                if(!visit[nei]) {
                    pq.add(new int[]{newDist, nei});
                }
            }
        }
        return res;
    }
}
