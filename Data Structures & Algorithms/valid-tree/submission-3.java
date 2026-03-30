class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
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
        return visiting.size() == n;
    }

    private boolean dfs(int i, int parent) {
        if(visiting.contains(i)) {
            return false;
        }
        visiting.add(i);
        for(int chi : map.get(i)) {
            if(chi != parent) {
                if(!dfs(chi, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
