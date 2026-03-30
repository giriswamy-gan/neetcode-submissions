class Trie {
    Map<Character, Trie> children;
    int idx;

    public Trie() {
        children = new HashMap<>();
        idx = -1;
    }

    public void insert(String word, int index) {
        Trie cur = this;
        for(char ch : word.toCharArray()) {
            cur.children.putIfAbsent(ch, new Trie());
            cur = cur.children.get(ch);
        }
        cur.idx = index;
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
        for(int i=0; i<words.length; ++i) {
            root.insert(words[i], i);
        }

        for(int r=0; r<ROWS; ++r) {
            for(int c=0; c<COLS; ++c) {
                dfs(r, c, board, words, root);
            }
        }
        return res;
    }

    private void dfs(int r, int c, char[][] board, String[] words, Trie cur) {
        if(cur.idx != -1) {
            res.add(words[cur.idx]);
            cur.idx = -1;
        }
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] == '#' || !cur.children.containsKey(board[r][c])) {
            return;
        }
        char ch = board[r][c];
        Trie next = cur.children.get(ch);
        board[r][c] = '#';
        dfs(r + 1, c, board, words, next);
        dfs(r - 1, c, board, words, next);
        dfs(r, c + 1, board, words, next);
        dfs(r, c - 1, board, words, next);
        board[r][c] = ch;
    }
}
