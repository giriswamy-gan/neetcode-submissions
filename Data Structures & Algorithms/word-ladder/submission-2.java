class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int n = wordList.size();
        int m = wordList.get(0).length();
        for(int i=0; i<n; ++i) {
            adjList.put(i, new ArrayList<>());
        }
        
        Map<String, Integer> mp = new HashMap<>();
        for(int i=0; i<n; ++i) {
            mp.put(wordList.get(i), i);
        }

        for(int i=0; i<n; ++i) {
            for(int j=i+1; j<n; ++j) {
                int diff = 0;
                for(int k=0; k<m; ++k) {
                    if(wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        diff++;
                    }
                }
                if(diff == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int res = 1;
        Set<Integer> visit = new HashSet<>();

        for(int i=0; i<m; ++i) {
            for(char c = 'a'; c <= 'z'; ++c) {
                if(c == beginWord.charAt(i)) {
                    continue;
                }
                String word = beginWord.substring(0, i) + c + beginWord.substring(i + 1);

                if(mp.containsKey(word) && !visit.contains(mp.get(word))) {
                    q.add(mp.get(word));
                    visit.add(mp.get(word));
                }
            }
        }

        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i=0; i<size; ++i) {
                int node = q.poll();
                String word = wordList.get(node);
                if(word.equals(endWord)) {
                    return res;
                }
                for(int chi : adjList.get(node)) {
                    if(!visit.contains(chi)) {
                        visit.add(chi);
                        q.add(chi);
                    }
                }
            }
        }

        return 0;
    }
}
