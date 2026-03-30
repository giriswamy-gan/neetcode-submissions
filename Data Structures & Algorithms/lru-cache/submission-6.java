class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    Node left;
    Node right;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        this.capacity = capacity;

        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {
        Node tmp = left.next;
        left.next = node;
        tmp.prev = node;
        node.prev = left;
        node.next = tmp;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node tmp = cache.get(key);
            remove(tmp);
        }
        Node node = new Node(key, value);
        add(node);
        cache.put(key, node);
        if(cache.size() > capacity) {
            Node rem = cache.get(right.prev.key);
            remove(rem);
            cache.remove(rem.key);
        }
    }
}
