class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class Deque {
    Node left;
    Node right;

    public Deque() {
        left = new Node(-1);
        right = new Node(-1);
        left.next = right;
        right.prev = left;
    }

    public boolean isEmpty() {
        return left.next == right;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        Node p = right.prev;
        p.next = newNode;
        newNode.prev = p;
        right.prev = newNode;
        newNode.next = right;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        Node n = left.next;
        n.prev = newNode;
        left.next = newNode;
        newNode.prev = left;
        newNode.next = n;
    }

    public int pop() {
        if(left.next == right) {
            return -1;
        }
        Node rem = right.prev;
        rem.prev.next = right;
        right.prev = rem.prev;
        rem.next = rem.prev = null;
        return rem.value;
    }

    public int popleft() {
        if(left.next == right) {
            return -1;
        }
        Node rem = left.next;
        rem.next.prev = left;
        left.next = rem.next;
        rem.next = rem.prev = null;
        return rem.value;
    }
}
