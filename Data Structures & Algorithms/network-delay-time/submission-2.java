class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int i=1; i<=n; ++i) {
            adjList.put(i, new ArrayList<>());
        }
        for(int[] time : times) {
            adjList.get(time[0]).add(new int[]{time[1], time[2]});
        }
        // System.out.println(adjList.get(k).get(0)[1]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, k});
        Set<Integer> visitedList = new HashSet<>();
        int time = 0;
        while(!minHeap.isEmpty() && visitedList.size() < n) {
            int[] pair = minHeap.poll();
            int w1 = pair[0];
            int node = pair[1];
            if(visitedList.contains(node)) {
                continue;
            }
            visitedList.add(node);
            time = w1;

            for(int[] nei : adjList.get(node)) {
                int chi = nei[0];
                int w2 = nei[1];
                if(!visitedList.contains(chi)) {
                    minHeap.add(new int[]{w1 + w2, chi});
                }
            }
        }
        return visitedList.size() == n ? time : -1;
    }
}
