class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        for(int i=0; i<n; ++i) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for(int i=0; i<n; ++i) {
            if(!visited.contains(i)) {
                count++;
                dfs(i);
            }
        }
        return count;
    }

    private void dfs(int i) {
        visited.add(i);
        for(int chi : map.get(i)) {
            if(!visited.contains(chi)) {
                dfs(chi);
            }
        }
    }
}
