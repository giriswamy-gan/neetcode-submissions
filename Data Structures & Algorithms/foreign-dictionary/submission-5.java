class Solution {
    Map<Character, List<Character>> adj = new HashMap<>();
    StringBuilder res;
    Set<Character> visited = new HashSet<>();
    Set<Character> visiting = new HashSet<>();

    public String foreignDictionary(String[] words) {
        Set<Character> allWords = new HashSet<>();
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new ArrayList<>());
                allWords.add(ch);
            }
        }
        for(int i = 1; i < words.length; ++i) {
            String word = words[i - 1], next = words[i];
            int wordLen = word.length(), nextLen = next.length();
            if(wordLen > nextLen && next.equals(word.substring(0, nextLen))) {
                return "";
            }
            int minLen = Math.min(wordLen, nextLen);
            for(int j = 0; j < minLen; ++j) {
                if(word.charAt(j) != next.charAt(j)) {
                    adj.get(word.charAt(j)).add(next.charAt(j));
                    break;
                }
            }
        }

        res = new StringBuilder();
        for(char ch : allWords) {
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
        for(char nei : adj.get(node)) {
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
