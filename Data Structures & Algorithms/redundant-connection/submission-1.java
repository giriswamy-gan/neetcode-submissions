class DSU {
    int[] Parent, Size;
    
    public DSU(int n) {
        Parent = new int[n + 1];
        Size = new int[n + 1];

        for(int i=0; i<n; ++i) {
            Parent[i] = i;
            Size[i] = 0;
        }
    }

    private int find(int node) {
        if(Parent[node] != node) {
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v) {
        int up = find(u);
        int vp = find(v);

        if(up == vp) {
            return false;
        }

        if(Size[up] > Size[vp]) {
            int temp = Size[up];
            Size[up] = Size[vp];
            temp = Size[up];
        }

        Size[vp] += Size[up];
        Parent[up] = vp;
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
