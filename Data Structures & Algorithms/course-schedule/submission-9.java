class Solution {
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList = new HashMap<>();
        for(int i=0; i<numCourses; ++i) {
            adjList.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            adjList.get(pre[0]).add(pre[1]);
        }
        for(int i=0; i<numCourses; ++i) {
            if(!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i) {
        if(visiting.contains(i)) {
            return false;
        }
        if(visited.contains(i)) {
            return true;
        }
        visiting.add(i);
        for(int nei : adjList.get(i)) {
            if(!dfs(nei)) {
                return false;
            }
        }
        visiting.remove(i);
        visited.add(i);
        return true;
    }
}
