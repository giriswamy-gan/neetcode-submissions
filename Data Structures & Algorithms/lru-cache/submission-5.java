private class Node {
    private int key;
    private int val;
    private Node next;
    private Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node left;
    Node right;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        this.capacity = capacity;

        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        Node leftNode = node.prev;
        Node rightNode = node.next;
        leftNode.next = rightNode;
        rightNode.prev = leftNode;
    }

    private void add(Node node) {
        Node temp = left.next;
        left.next = node;
        node.next = temp;
        node.prev = left;
        temp.prev = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node del = map.get(key);
            remove(del);
        }

        Node node = new Node(key, value);
        add(node);
        map.put(key, node);
        if(map.size() > capacity) {
            Node del = map.get(right.prev.key);
            remove(del);
            map.remove(del.key);
        }
    }
}
