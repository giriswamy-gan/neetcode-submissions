private static class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    Map<Integer, ListNode> cache;
    ListNode left;
    ListNode right;
    int limit;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        left = new ListNode(-1, -1);
        right = new ListNode(-1, -1);
        left.next = right;
        right.prev = left;
        this.limit = capacity;
    }

    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void add(ListNode node) {
        ListNode next = left.next;
        next.prev = node;
        left.next = node;
        node.prev = left;
        node.next = next;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        ListNode node = cache.get(key);
        remove(node);
        add(node);
        System.out.println(node.val);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            ListNode node = cache.get(key);
            remove(node);
            node.val = value;
            add(node);
            return;
        }
        ListNode node = new ListNode(key, value);
        add(node);
        cache.put(key, node);
        if(cache.size() > limit) {
            ListNode rem = right.prev;
            remove(rem);
            cache.remove(rem.key);
        }
        System.out.println(key);
    }
}
