class Solution {
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList = new HashMap<>();
        for(int i=0; i<numCourses; ++i) {
            adjList.put(i, new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adjList.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            finish++;
            for(int nei : adjList.get(cur)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        return finish == numCourses;
    }
}
