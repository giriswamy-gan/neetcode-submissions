class DSU {
    int[] Parent;
    int[] Size;

    public DSU(int n) {
        Parent = new int[n];
        Size = new int[n];

        for(int i=0; i<n; ++i) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }

    private int find(int chi) {
        if(Parent[chi] != chi) {
            Parent[chi] = find(Parent[chi]);
        }
        return Parent[chi];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if(pu == pv) {
            return false;
        }
        if(Size[pu] > Size[pv]) {
            Size[pu] += Size[pv];
            Parent[pv] = pu;
        }
        else {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
        }
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        DSU dsu = new DSU(points.length);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0; i<points.length; ++i) {
            for(int j=0; j<points.length; ++j) {
                if(i == j) continue;
                int cost = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                minHeap.add(new int[]{cost, i, j});
            }
        }

        int mst = 0;
        int edges = 0;
        while(!minHeap.isEmpty() && edges < points.length) {
            int[] cur = minHeap.poll();
            int cost = cur[0], u = cur[1], v = cur[2];
            if(!dsu.union(u, v)) {
                continue;
            }
            mst += cost;
            edges++;
        }
        return mst;
    }
}
