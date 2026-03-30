class Solution {
    Map<Character, List<Character>> adj;
    StringBuilder res = new StringBuilder();
    Set<Character> visit = new HashSet<>();
    Set<Character> visited = new HashSet<>();
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        for(String word : words) {
            for(int i = 0; i < word.length(); ++i) {
                adj.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }
        for(int i = 0; i + 1 < words.length; ++i) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if(w1.startsWith(w2) && w1.length() > w2.length()) {
                return "";
            }
            int size = Math.min(w1.length(), w2.length());
            for(int j = 0; j < size; ++j) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for(Map.Entry<Character, List<Character>> entry : adj.entrySet()) {
            if(!dfs(entry.getKey())) {
                return "";
            }
        }
        
        return res.reverse().toString();
    }

    private boolean dfs(char ch) {
        if(visited.contains(ch)) {
            return true;
        }
        if(visit.contains(ch)) {
            return false;
        }
        visit.add(ch);
        for(char nei : adj.getOrDefault(ch, Collections.emptyList())) {
            if(!dfs(nei)) {
                return false;
            }
        }
        visited.add(ch);
        visit.remove(ch);
        res.append(ch);
        return true;
    }
}
