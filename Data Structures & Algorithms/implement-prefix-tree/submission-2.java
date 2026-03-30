class Trie {
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        children = new HashMap<>();
        isWord = false;
    }
}

class PrefixTree {
    Trie root;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
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
        Trie cur = root;
        for(char ch : word.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie cur = root;
        for(char ch : prefix.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return true;
    }
}
