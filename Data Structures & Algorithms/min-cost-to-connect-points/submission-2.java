class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int i=0; i<points.length; ++i) {
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < points.length; ++i) {
            for(int j = 0; j < points.length; ++j) {
                if(i == j) continue;
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjList.get(i).add(new int[]{cost, j});
            }
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0});

        Set<Integer> visited = new HashSet<>();
        int minCost = 0;
        
        while(!minHeap.isEmpty() && visited.size() < points.length) {
            int[] cur = minHeap.poll();
            int cost = cur[0], i = cur[1];

            if(visited.contains(i)) continue;

            minCost += cost;
            visited.add(i);
            for(int[] nei : adjList.get(i)) {
                if(!visited.contains(nei[1])) {
                    minHeap.add(nei);
                }
            }
        }
        return minCost;
    }
}
