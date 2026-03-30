class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs("JFK");
        Collections.reverse(res);

        return res;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = adj.get(src);
        while(pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        res.add(src);
    }
}
