class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        int cur = 0, edges = 0;
        int cost = 0;
        boolean[] visit = new boolean[n];
        while(edges < n - 1) {
            visit[cur] = true;
            int resIdx = -1;
            for(int i = 0; i < n; ++i) {
                if(visit[i]) continue;
                int newDist = Math.abs(points[i][0] - points[cur][0]) + Math.abs(points[i][1] - points[cur][1]);
                dist[i] = Math.min(dist[i], newDist);
                if(resIdx == -1 || dist[i] < dist[resIdx]) {
                    resIdx = i;
                }
            }
            cost += dist[resIdx];
            cur = resIdx;
            edges++;
        }
        return cost;
    }
}
