class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0; i<numCourses; ++i) {
            map.put(i, new ArrayList<>());
        }
        for(int[] p : prerequisites) {
            map.get(p[0]).add(p[1]);
        }

        for(int i=0; i<numCourses; ++i) {
            if(!dfs(i)) {
                return new int[0];
            }
        }
        int[] output = new int[numCourses];
        for(int i=0; i<numCourses; ++i) {
            output[i] = res.get(i);
        }
        return output;
    }

    private boolean dfs(int i) {
        if(visiting.contains(i)) {
            return false;
        }
        if(visited.contains(i)) {
            return true;
        }

        visiting.add(i);
        for(int chi : map.get(i)) {
            if(!dfs(chi)) {
                return false;
            }
        }
        visiting.remove(i);
        visited.add(i);
        res.add(i);
        return true;
    }
}
