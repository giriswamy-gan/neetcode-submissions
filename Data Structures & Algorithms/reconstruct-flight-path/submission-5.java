class Solution {
    Map<String, PriorityQueue<String>> adj;
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for(List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }

        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String cur) {
        PriorityQueue<String> pq = adj.get(cur);
        while (pq != null && !pq.isEmpty()) {
            String dst = pq.poll();
            dfs(dst);
        }
        res.add(cur);
    }
}
