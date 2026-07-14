class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] deg = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            deg[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i) {
            if(deg[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for(int v : adj.get(u)) {
                if(--deg[v] == 0) {
                    q.add(v);
                }
            }
        }
        if(res.size() == numCourses) {
            int[] output = new int[numCourses];
            for(int i = 0; i < res.size(); ++i) {
                output[i] = res.get(i);
            }
            return output;
        }
        else {
            return new int[0];
        }
    }
}
