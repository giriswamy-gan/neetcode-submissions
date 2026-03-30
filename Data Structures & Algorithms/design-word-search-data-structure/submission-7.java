class Trie {
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie cur = root;
        for(char ch : word.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                cur.children.put(ch, new Trie());
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }

    private boolean dfs(int i, Trie cur, String word) {
        if(i == word.length()) {
            return cur.isWord;
        }
        char ch = word.charAt(i);
        if(ch == '.') {
            for(Map.Entry<Character, Trie> entry : cur.children.entrySet()) {
                if(dfs(i + 1, entry.getValue(), word)) {
                    return true;
                }
            }
            return false;
        }
        else {
            if(cur.children.containsKey(ch)) {
                return dfs(i + 1, cur.children.get(ch), word);
            }
            else {
                return false;
            }
        }
    }
}
