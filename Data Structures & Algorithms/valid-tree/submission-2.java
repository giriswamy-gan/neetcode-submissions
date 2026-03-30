class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    int visitCount = 0;
    public boolean validTree(int n, int[][] edges) {
        for(int i=0; i<n; ++i) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        if(!dfs(0, -1)) {
            return false;
        }
        return visitCount == n;
    }

    private boolean dfs(int i, int parent) {
        if(visiting.contains(i)) {
            return false;
        }
        visitCount++;
        visiting.add(i);
        for(int chi : map.get(i)) {
            if(chi != parent) {
                if(!dfs(chi, i)) {
                    return false;
                }
            }
        }
        System.out.println(i);
        visiting.remove(i);
        return true;
    }
}
