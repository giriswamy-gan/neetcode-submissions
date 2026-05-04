class DSU {
    int[] Parent;
    int[] Size;

    public DSU(int n) {
        Parent = new int[n + 1];
        Size = new int[n + 1];

        for(int i = 0; i <= n; ++i) {
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
        if(pu == pv) {
            return false;
        }
        if(Size[pu] > Size[pv]) {
            Parent[pv] = pu;
            Size[pu] += Size[pv];
        }
        else {
            Parent[pu] = pv;
            Size[pv] += Size[pu];
        }
        return true;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        List<int[]> dist = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                int d = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                dist.add(new int[]{d, i, j});
            }
        }
        dist.sort((a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        for(int[] d : dist) {
            if(dsu.union(d[1], d[2])) {
                res += d[0];
            }
        }
        return res;
    }
}
