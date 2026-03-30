class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String, List<String>> adj = new HashMap<>();
        for(String word : wordList) {
            for(int i=0; i<word.length(); ++i) {
                String node = word.substring(0, i) + '*' + word.substring(i+1);
                adj.computeIfAbsent(node, k -> new ArrayList<>()).add(word);
            }
        }
        Set<String> visit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 0;
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i=0; i<size; ++i) {
                String cur = q.poll();
                visit.add(cur);
                if(cur.equals(endWord)) {
                    return res;
                }
                for(int j=0; j<cur.length(); ++j) {
                    String nei = cur.substring(0, j) + '*' + cur.substring(j+1);
                    if(adj.containsKey(nei)) {
                        for(String word : adj.get(nei)) {
                            if(!visit.contains(word)) {
                                q.add(word);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
