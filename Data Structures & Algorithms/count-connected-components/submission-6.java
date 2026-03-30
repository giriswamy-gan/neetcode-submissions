class DSU {
    int[] Parent, Size;
    int comp;

    public DSU(int n) {
        Parent = new int[n];
        Size = new int[n];
        comp = n;

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

    public void union(int u, int v) {
        int up = find(u);
        int vp = find(v);
        if(up == vp) return;
        if(Size[up] > Size[vp]) {
            int temp = Size[up];
            Size[up] = Size[vp];
            Size[vp] = temp;
        }
        Size[vp] += Size[up];
        Parent[up] = vp;
        comp--;
    }

    public int components() {
        return this.comp;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        return dsu.components();
    }
}
