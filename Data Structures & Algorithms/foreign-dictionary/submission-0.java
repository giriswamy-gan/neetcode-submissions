class Solution {
    List<Character> res = new ArrayList<>();
    Map<Character, List<Character>> adj = new HashMap<>();
    Set<Character> visiting = new HashSet<>();
    Set<Character> visited = new HashSet<>();
    public String foreignDictionary(String[] words) {
        for(String word : words) {
            for(char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
            }
        }
        for(int i=0; i<words.length - 1; ++i) {
            String w1 = words[i], w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.substring(0, minLength).equals(w2.substring(0, minLength))) {
                return "";
            }
            for(int j = 0; j < minLength; ++j) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for(char c : adj.keySet()) {
            if(!dfs(c)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = res.size() - 1; i >= 0; --i) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    private boolean dfs(char c) {
        if(visited.contains(c)) {
            return true;
        }
        if(visiting.contains(c)) {
            return false;
        }
        visiting.add(c);
        for(char nei : adj.get(c)) {
            if(!dfs(nei)) {
                return false;
            }
        }
        visiting.remove(c);
        visited.add(c);
        res.add(c);
        return true;
    }
}
