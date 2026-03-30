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

        Node l1 = head;
        while(l1 != null) {
            Node l2 = new Node(l1.val);
            l2.next = l1.next;
            l1.next = l2;
            if(l2 != null) {
                l1 = l2.next;
            } else {
                break;
            }
        }

        l1 = head;
        while(l1 != null) {
            Node l2 = l1.next;
            if(l1.random != null) {
                l2.random = l1.random.next;
            }
            l1 = l2.next;
        }

        l1 = head;
        Node res = l1.next;
        while(l1 != null) {
            Node l2 = l1.next;
            l1.next = l2.next;
            if(l2.next != null) {
                l2.next = l2.next.next;
            } else {
                l2.next = null;
            }
            l1 = l1.next;
        }
        return res;
    }
}
