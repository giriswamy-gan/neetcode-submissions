class Trie {
    Trie[] children;
    int idx;
    int refs;

    public Trie() {
        children = new Trie[26];
        idx = -1;
        refs = 0;
    }

    public void insert(String word, int i) {
        Trie root = this;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(root.children[idx] == null) {
                root.children[idx] = new Trie();
            }
            root.refs++;
            root = root.children[idx];
        }
        root.idx = i;
    }
}

class Solution {
    int ROWS;
    int COLS;
    List<String> res;
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
                dfs(r, c, board, words, root);
            }
        }
        
        return res;
    }

    private void dfs(int r, int c, char[][] board, String[] words, Trie root) {
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] == '#' 
        || root.children[board[r][c] - 'a'] == null) {
            return;
        }

        Trie prev = root;
        root = root.children[board[r][c] - 'a'];
        if(root.idx != -1) {
            res.add(words[root.idx]);
            root.idx = -1;
            if(root.refs == 0) {
                prev.refs--;
                prev = null;
                return;
            }
        }

        char ch = board[r][c];
        board[r][c] = '#';

        dfs(r + 1, c, board, words, root);
        dfs(r - 1, c, board, words, root);
        dfs(r, c + 1, board, words, root);
        dfs(r, c - 1, board, words, root);

        board[r][c] = ch;
    }
}
