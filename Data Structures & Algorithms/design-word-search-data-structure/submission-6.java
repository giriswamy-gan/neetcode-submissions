private class Trie {
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}

class WordDictionary {
    Trie root;

    public WordDictionary() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        Trie cur = this.root;
        for(char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Trie());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(this.root, word, 0);
    }

    private boolean searchHelper(Trie cur, String word, int i) {
        if(i == word.length()) return cur.isWord;
        
        char c = word.charAt(i);
        if(c == '.') {
            for(Map.Entry<Character, Trie> entry : cur.children.entrySet()) {
                if(searchHelper(entry.getValue(), word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
        else {
            if(!cur.children.containsKey(c)) {
                return false;
            }
            else {
                return searchHelper(cur.children.get(c), word, i + 1);
            }
        }
    }
}
