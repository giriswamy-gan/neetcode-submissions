class Trie {
    Trie[] children;
    int idx;
    int refs;

    public Trie() {
        children = new Trie[26];
        idx = -1;
        refs = 0;
    }

    private void insert(String s, int i) {
        Trie cur = this;
        cur.refs++;
        for(char ch : s.toCharArray()) {
            int index = ch - 'a';
            if(cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
            cur.refs++;
        }
        cur.idx = i;
    }
}

class Solution {
    List<String> res = new ArrayList<>();
    int ROWS;
    int COLS;
    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        Trie root = new Trie();
        for(int i = 0; i < words.length; ++i) {
            root.insert(words[i], i);
        }

        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                dfs(r, c, board, words, root);
            }
        }
        return res;
    }

    private void dfs(int r, int c, char[][] board, String[] words, Trie root) {
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] == '#' || 
        root.children[board[r][c]- 'a'] == null) {
            return;
        }
        char ch = board[r][c];
        Trie prev = root;
        root = root.children[ch - 'a'];

        if(root.idx != -1) {
            res.add(words[root.idx]);
            root.idx = -1;
            root.refs--;
            if(root.refs == 0) {
                root = null;
                prev.children[ch - 'a'] = null;
                return;
            }
        }

        board[r][c] = '#';

        dfs(r + 1, c, board, words, root);
        dfs(r - 1, c, board, words, root);
        dfs(r, c + 1, board, words, root);
        dfs(r, c - 1, board, words, root);

        board[r][c] = ch;
    }
}
