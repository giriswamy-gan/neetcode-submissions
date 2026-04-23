class DSU {
    int[] Parent;
    int[] Size;

    public DSU(int n) {
        Parent = new int[n];
        Size = new int[n];

        for(int i = 0; i < n; ++i) {
            Parent[i] = i;
            Size[i] = 1;
        }
    }

    private int find(int node) {
        if(Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if(pu == pv) return false;
        if(Size[pu] < Size[pv]) {
            Parent[pu] = pv;
            Size[pv] += Size[pu];
        }
        else {
            Parent[pv] = pu;
            Size[pu] += Size[pv];
        }
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        DSU dsu = new DSU(points.length);
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < points.length - 1; ++i) {
            for(int j = i + 1; j < points.length; ++j) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }
        edges.sort((a, b) -> Integer.compare(a[0], b[0]));
        int cost = 0;
        for(int[] edge : edges) {
            if(dsu.union(edge[1], edge[2])) {
                cost += edge[0];
            }
        }
        return cost;
    }
}
