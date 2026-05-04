class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e7);
        int edges = 0;
        boolean[] visit = new boolean[n];
        int node = 0;
        int res = 0;
        while(edges < n - 1) {
            int next = -1;
            visit[node] = true;
            for(int i = 0; i < n; ++i) {
                if(visit[i]) continue;
                int newDist = Math.abs(points[i][0] - points[node][0]) + Math.abs(points[i][1] - points[node][1]);
                dist[i] = Math.min(dist[i], newDist);
                if(next == -1 || dist[i] < dist[next]) {
                    next = i;
                }
            }
            res += dist[next];
            node = next;
            edges++;
        }
        return res;
    }
}
