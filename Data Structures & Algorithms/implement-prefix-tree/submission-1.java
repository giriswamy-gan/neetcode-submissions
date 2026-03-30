private class Trie {
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}

class PrefixTree {
    private Trie root;

    public PrefixTree() {
        this.root = new Trie();
    }

    public void insert(String word) {
        Trie cur = this.root;
        for(char ch: word.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                cur.children.put(ch, new Trie());
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Trie cur = this.root;
        for(char ch: word.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this.root;
        for(char ch: prefix.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return true;
    }
}
