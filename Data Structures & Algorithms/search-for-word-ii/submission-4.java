class Trie {
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word) {
        Trie cur = this;
        for(char ch : word.toCharArray()) {
            if(!cur.children.containsKey(ch)) {
                cur.children.put(ch, new Trie());
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
}

class Solution {
    int ROWS;
    int COLS;
    Set<String> res;
    boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        visit = new boolean[ROWS][COLS];

        Trie root = new Trie();
        for(String word : words) {
            root.addWord(word);
        }

        res = new HashSet<>();
        for(int r=0; r<ROWS; ++r) {
            for(int c=0; c<COLS; ++c) {
                dfs("", r, c, board, root);
            }
        }
        
        return new ArrayList<>(res);
    }

    private void dfs(String word, int r, int c, char[][] board, Trie node) {
        if(node.isWord) {
            res.add(word);
        }

        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || visit[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = true;
        char ch = board[r][c];
        node = node.children.get(ch);

        dfs(word + ch, r + 1, c, board, node);
        dfs(word + ch, r - 1, c, board, node);
        dfs(word + ch, r, c + 1, board, node);
        dfs(word + ch, r, c - 1, board, node);

        visit[r][c] = false;
    }
}
