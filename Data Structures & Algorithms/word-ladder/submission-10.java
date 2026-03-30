class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 0;
        Set<String> words = new HashSet<>(wordList);

        while(!q.isEmpty()) {
            res++;
            int size = q.size();
            for(int i = 0; i < size; ++i) {
                String wrd = q.poll();
                if(wrd.equals(endWord)) return res;
                for(int j = 0; j < wrd.length(); ++j) {
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        String tmp = wrd.substring(0, j) + ch + wrd.substring(j + 1);
                        if(words.contains(tmp)) {
                            q.add(tmp);
                            words.remove(tmp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
