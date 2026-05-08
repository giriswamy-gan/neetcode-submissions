class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    private Map<Integer, Node> cache;
    private Node left;
    private Node right;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
    }

    private void add(Node node) {
        Node n = left.next;
        node.prev = left;
        node.next = n;
        n.prev = node;
        left.next = node;
    }

    private void remove(Node node) {
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
        node.prev = node.next = null;
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
            Node node = cache.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        add(node);
        cache.put(key, node);
        if(cache.size() > capacity) {
            Node rem = right.prev;
            remove(rem);
            cache.remove(rem.key);
        }
    }
}
