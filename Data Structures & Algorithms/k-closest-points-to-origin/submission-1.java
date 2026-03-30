class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for(int i=0; i<points.length; ++i) {
            int[] p = points[i];
            int dist = p[0] * p[0] + p[1] * p[1];
            pq.add(new int[]{dist, i});
            if(pq.size() > k) {
                // System.out.println(dist);
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(pq.size() > 0) {
            // System.out.println(i);
            int[] p = points[pq.poll()[1]];
            res[i][0] = p[0];
            res[i][1] = p[1];
            i++;
        }
        return res;
    }
}
