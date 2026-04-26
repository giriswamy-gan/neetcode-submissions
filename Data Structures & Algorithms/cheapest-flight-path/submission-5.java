class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i = 0; i <= k; ++i) {
            int[] newDist = Arrays.copyOf(dist, n);
            for(int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int cost = flight[2];
                
                if(dist[s] != Integer.MAX_VALUE) {
                    newDist[d] = Math.min(newDist[d], dist[s] + cost);
                }
            }
            dist = newDist;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

// dist = [0, inf, inf, inf]
// newDist = [0, inf, inf, inf]
// 
