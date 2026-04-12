class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[] dist = new int[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visit = new boolean[points.length];
        int cur = 0, size = 0;
        int cost = 0;

        while(size < points.length - 1) {
            int[] node = points[cur];
            visit[cur] = true;
            int res = -1;
            for(int i = 0; i < points.length; ++i) {
                if(visit[i]) continue;
                int curDist = Math.abs(node[0] - points[i][0]) + Math.abs(node[1] - points[i][1]);
                dist[i] = Math.min(dist[i], curDist);
                if(res == -1 || dist[i] < dist[res]) {
                    res = i;
                }
            }
            System.out.println(res);
            cost += dist[res];
            cur = res;
            size++;
        }
        return cost;
    }
}
