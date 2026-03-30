class Solution {
    Map<String, List<String>> adj;
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for(List<String> ticket : tickets) {
            adj.put(ticket.get(0), new ArrayList<>());
            adj.put(ticket.get(1), new ArrayList<>());
        }
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        res = new ArrayList<>();
        res.add("JFK");
        if(dfs("JFK", tickets.size() + 1)) {
            return res;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String src, int target) {
        if(res.size() == target) {
            return true;
        }
        List<String> temp = new ArrayList<>(adj.get(src));
        for(int i = 0; i < temp.size(); ++i) {
            String cur = temp.get(i);
            adj.get(src).remove(cur);
            res.add(cur);
            if(dfs(cur, target)) return true;
            res.remove(res.size() - 1);
            adj.get(src).add(cur);
        }
        return false;
    }
}
