class DSU {
    int[] Parent;
    int[] Size;

    public DSU(int n) {
        Parent = new int[n + 1];
        Size = new int[n + 1];

        for(int i=0; i<=n; ++i) {
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
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for(int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}
