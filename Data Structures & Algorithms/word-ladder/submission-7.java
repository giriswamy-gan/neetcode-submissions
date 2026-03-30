class Solution {
    // Map<String, List<String>> adj = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        // for(String word : wordList) {
        //     adj.put(word, new ArrayList<>());
        // }
        int res = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        q.add(beginWord);
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i=0; i<size; ++i) {
                String cur = q.poll();
                if(cur.equals(endWord)) {
                    return res;
                }
                for(int j=0; j<cur.length(); ++j) {
                    for(char c = 'a'; c <= 'z'; ++c) {
                        if(cur.charAt(j) == c) continue;
                        String nei = cur.substring(0, j) + c + cur.substring(j + 1);
                        if(words.contains(nei)) {
                            words.remove(nei);
                            q.add(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
