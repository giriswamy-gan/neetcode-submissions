class Trie {
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        children = new HashMap<>();
        isWord = false;
    }

    private void insert(String s) {
        Trie cur = this;
        for(char ch : s.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                cur.children.put(ch, new Trie());
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
}

class Solution {
    Set<String> res;
    int ROWS;
    int COLS;
    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        Trie root = new Trie();
        for(String word : words) {
            root.insert(word);
        }

        res = new HashSet<>();
        for(int r = 0; r < ROWS; ++r) {
            for(int c = 0; c < COLS; ++c) {
                dfs(r, c, board, "", root);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int r, int c, char[][] board, String cur, Trie root) {
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] == '#' || !root.children.containsKey(board[r][c])) {
            return;
        }
        char ch = board[r][c];
        root = root.children.get(ch);
        if(root.isWord) {
            res.add(cur + ch);
        }
        board[r][c] = '#';
        dfs(r + 1, c, board, cur + ch, root);
        dfs(r - 1, c, board, cur + ch, root);
        dfs(r, c + 1, board, cur + ch, root);
        dfs(r, c - 1, board, cur + ch, root);
        board[r][c] = ch;
    }
}
