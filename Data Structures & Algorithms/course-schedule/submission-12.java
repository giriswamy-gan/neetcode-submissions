class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < numCourses; ++i) {
            adj.put(i, new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        for(int i = 0; i < numCourses; ++i) {
            if(indegree[i] == 0) {
                q.add(i);
                visit.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int nei : adj.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0 && !visit.contains(nei)) {
                    q.add(nei);
                    visit.add(nei);
                }
            }
        }
        return visit.size() == numCourses;
    }
}
