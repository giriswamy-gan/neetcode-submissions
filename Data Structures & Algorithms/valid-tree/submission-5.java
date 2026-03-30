// DSU
class DSU {
    int[] Parent, Size;
    int comp;

    public DSU(int n) {
        this.comp = n;
        Parent = new int[n];
        Size = new int[n];
        for(int i=0; i<n; ++i) {
            Parent[i] = i;
            Size[i] = 0;
        }
    }

    private int find(int i) {
        if(Parent[i] != i) {
            Parent[i] = find(Parent[i]);
        }
        return Parent[i];
    }

    public boolean union(int u, int v) {
        int up = find(u);
        int vp = find(v);
        if(up == vp) {
            return false;
        }
        if(Size[up] < Size[vp]) {
            int temp = up;
            up = vp;
            vp = temp;
        }
        comp--;
        Size[up] += Size[vp];
        Parent[vp] = up;
        return true;
    }
    
    public int components() {
        return this.comp;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n) {
            return false;
        }
        DSU dsu = new DSU(n);
        for(int[] edge : edges) {
            if(!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }
        return dsu.components() == 1;
    }
}
