class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if(cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }
}
