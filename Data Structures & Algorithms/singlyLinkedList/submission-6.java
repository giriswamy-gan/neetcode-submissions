class Node {
    int val;
    Node next;

    public Node() {
        this.val = -1;
        this.next = null;
    }
}

class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        this.head = new Node();
        this.tail = head;
    }

    public int get(int index) {
        int i = 0;
        Node curr = head.next;
        while(curr != null) {
            if(i == index) {
                return curr.val;
            }
            curr = curr.next;
            ++i;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node curr = new Node();
        curr.val = val;
        curr.next = head.next;
        head.next = curr;
        if(curr.next == null) {
            tail = curr;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        this.tail.next = newNode;
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        Node curr = this.head;
        while(curr != null && i < index) {
            curr = curr.next;
            ++i;
        }
        if(curr != null && curr.next != null) {
            if(curr.next == this.tail) {
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node curr = this.head.next;
        while(curr != null) {
            result.add(curr.val);
            curr = curr.next;
        }
        return result;
    }
}
