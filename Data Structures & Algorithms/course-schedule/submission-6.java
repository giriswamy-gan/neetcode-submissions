class Solution {
    Set<Integer> visit = new HashSet<>();
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        for(int[] pre : prerequisites) {
            adjList.putIfAbsent(pre[0], new ArrayList<>());
            adjList.putIfAbsent(pre[1], new ArrayList<>());
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
        if(visit.contains(i)) {
            return false;
        }
        if(!adjList.containsKey(i) || adjList.get(i).isEmpty()) {
            return true;
        }

        visit.add(i);
        for(int chi : adjList.get(i)) {
            if(!dfs(chi)) {
                return false;
            }
        }
        visit.remove(i);
        adjList.put(i, new ArrayList<>());
        return true;
    }
}
