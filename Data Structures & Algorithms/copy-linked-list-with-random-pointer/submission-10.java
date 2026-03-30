/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        while(cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }

        cur = head;
        while(cur != null) {
            Node temp = cur.next;
            if(cur.random != null) {
                temp.random = cur.random.next;
            }
            cur = temp.next;
        }

        cur = head;
        Node res = cur.next;
        while(cur != null) {
            Node temp = cur.next;
            cur.next = temp.next;
            if(temp.next != null) {
                temp.next = temp.next.next;
            }
            cur = cur.next;
        }
        return res;
    }
}
