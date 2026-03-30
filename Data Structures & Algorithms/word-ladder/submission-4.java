class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String, List<String>> mp = new HashMap<>();
        wordList.add(beginWord);
        for(String word : wordList) {
            for(int i=0; i<wordList.get(0).length(); ++i) {
                String wrd = word.substring(0, i) + "*" + word.substring(i + 1);
                mp.computeIfAbsent(wrd, k -> new ArrayList<>()).add(word);
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 0;
        Set<String> visit = new HashSet<>();
        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i=0; i<size; ++i) {
                String node = q.poll();
                if(node.equals(endWord)) return res;
                
                for(int j=0; j<node.length(); ++j) {
                    String pattern = node.substring(0, j) + "*" + node.substring(j + 1);
                    for(String nei : mp.get(pattern)) {
                        if(!visit.contains(nei)) {
                            q.add(nei);
                            visit.add(nei);
                        }
                    }
                }           
            }
        }
        return 0;
    }
}
