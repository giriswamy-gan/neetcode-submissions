class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key) {
        this.key = key;
        val = 0;
        next = null;
        prev = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node leftNode;
    Node rightNode;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        leftNode = new Node(-1);
        rightNode = new Node(-1);
        leftNode.next = rightNode;
        rightNode.prev = leftNode;
        size = 0;
        this.capacity = capacity;
    }

    private void removeNode(Node node) {
        Node right = node.next;
        Node left = node.prev;
        left.next = right;
        right.prev = left;
        node.prev = node.next = null;
    }

    private void addNode(Node node) {
        Node temp = leftNode.next;
        leftNode.next = node;
        temp.prev = node;
        node.prev = leftNode;
        node.next = temp;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addNode(node);
            return;
        }

        if(size == capacity) {
            Node remove = rightNode.prev;
            map.remove(remove.key);
            removeNode(remove);
            size--;
        }
        size++;

        Node node = new Node(key);
        node.val = value;
        map.put(key, node);
        addNode(node);
    }
}
