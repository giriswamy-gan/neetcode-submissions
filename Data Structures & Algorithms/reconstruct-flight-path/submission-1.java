class Solution {
    Map<String, List<String>> adjList = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets) {
            adjList.putIfAbsent(ticket.get(0), new ArrayList<>());
        }
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket : tickets) {
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }
        res.add("JFK");
        if(dfs("JFK", tickets.size() + 1)) {
            return res;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String s, int target) {
        if(res.size() == target) {
            return true;
        }
        if(!adjList.containsKey(s)) {
            return false;
        }
        List<String> temp = new ArrayList<>(adjList.get(s));
        for(int i=0; i<temp.size(); ++i) {
            String v = temp.get(i);
            res.add(v);
            adjList.get(s).remove(v);
            if(dfs(v, target)) {
                return true;
            }
            adjList.get(s).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
