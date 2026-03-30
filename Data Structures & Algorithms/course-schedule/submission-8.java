class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0; i<numCourses; ++i) {
            adjList.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adjList.get(pre[0]).add(pre[1]);
        }
        Deque<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; ++i) {
            if(indegree[i] == 0) {
                System.out.println(i);
                q.add(i);
            }
        }
        int finish = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            finish++;
            for(int chi : adjList.get(cur)) {
                indegree[chi]--;
                if(indegree[chi] == 0) {
                    q.add(chi);
                }
            }
        }
        return finish == numCourses;
    }
}
