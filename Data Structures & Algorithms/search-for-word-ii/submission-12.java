class Trie {
    Trie[] children;
    int refs;
    int idx;

    public Trie() {
        children = new Trie[26];
        refs = 0;
        idx = -1;
    }

    public void insert(String word, int index) {
        Trie root = this;
        root.refs++;
        for(char ch : word.toCharArray()) {
            int i = ch - 'a';
            if(root.children[i] == null) {
                root.children[i] = new Trie();
            }
            root = root.children[i];
            root.refs++;
        }
        root.idx = index;
    }
}

class Solution {
    List<String> res;
    int ROWS;
    int COLS;
    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;

        Trie root = new Trie();
        for(int i = 0; i < words.length; ++i) {
            root.insert(words[i], i);
        }
        res = new ArrayList<>();

        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                dfs(r, c, board, root, words);
            }
        }
        return res;
    }

    private void dfs(int r, int c, char[][] board, Trie node, String[] words) {
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] == '#' 
          || node.children[board[r][c] - 'a'] == null) {
            return;
        }

        char cur = board[r][c];
        Trie nextNode = node.children[cur - 'a'];
        if(nextNode.idx != -1) {
            res.add(words[nextNode.idx]);
            nextNode.idx = -1;
            nextNode.refs--;
            if(nextNode.refs == 0) {
                nextNode = null;
                node.children[cur - 'a'] = null;
                return;
            }
        }
        board[r][c] = '#';
        dfs(r + 1, c, board, nextNode, words);
        dfs(r - 1, c, board, nextNode, words);
        dfs(r, c + 1, board, nextNode, words);
        dfs(r, c - 1, board, nextNode, words);
        board[r][c] = cur;
    }
}
