class Solution {
    Map<Character, List<Character>> adj;
    StringBuilder res;
    Set<Character> visiting = new HashSet<>();
    Set<Character> visited = new HashSet<>();
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        Set<Character> chars = new HashSet<>();
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                chars.add(ch);
            }
        }
        for(int i = 1; i < words.length; ++i) {
            String w1 = words[i - 1];
            String w2 = words[i];
            if(w1.length() > w2.length() && w1.substring(0, w2.length()).equals(w2)) {
                return "";
            }
            int minLen = Math.min(w1.length(), w2.length());
            for(int j = 0; j < minLen; ++j) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    adj.putIfAbsent(w1.charAt(j), new ArrayList<>());
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        res = new StringBuilder();
        for(char ch : chars) {
            if(!dfs(ch)) {
                return "";
            }
        }
        return res.reverse().toString();
    }

    private boolean dfs(char node) {
        if(visited.contains(node)) {
            return true;
        }
        if(visiting.contains(node)) {
            return false;
        }
        visiting.add(node);
        List<Character> neighbors = adj.getOrDefault(node, Collections.emptyList());
        for(char nei : neighbors) {
            if(!dfs(nei)) {
                return false;
            }
        }
        visiting.remove(node);
        visited.add(node);
        res.append(node);
        return true;
    }
}
