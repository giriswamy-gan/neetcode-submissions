class Solution {
    public int minCostConnectPoints(int[][] points) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[points.length];
        Arrays.fill(dist, (int) 1e7);
        boolean[] visit = new boolean[points.length];
        q.add(0);
        int res = 0;
        int edges = 0, cur = 0;

        while(edges < points.length - 1) {
            visit[cur] = true;
            int nextNode = -1;

            for(int i = 0; i < points.length; ++i) {
                if(visit[i]) continue;
                int distance = Math.abs(points[cur][0] - points[i][0]) + Math.abs(points[cur][1] - points[i][1]);
                dist[i] = Math.min(distance, dist[i]);
                if(nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }
            res += dist[nextNode];
            cur = nextNode;
            edges++;
        }

        return res;
    }
}
