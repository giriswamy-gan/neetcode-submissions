class Solution {
    // Map<String, List<String>> adj = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        // for(String word : wordList) {
        //     adj.put(word, new ArrayList<>());
        // }
        int res = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        q.add(beginWord);
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i=0; i<size; ++i) {
                String cur = q.poll();
                if(cur.equals(endWord)) {
                    return res;
                }
                visit.add(cur);
                for(String word : wordList) {
                    if(cur == word || visit.contains(word)) continue;
                    int dif = 0;
                    for(int j=0; j<cur.length(); ++j) {
                        if(cur.charAt(j) != word.charAt(j)) {
                            dif++;
                        }
                    }
                    if(dif == 1) {
                        q.add(word);
                    }
                }
            }
        }
        return 0;
    }
}
