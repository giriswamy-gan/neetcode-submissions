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
        Map<Node, Node> oldToNew = new HashMap<>();
        // Node dummy = new Node(0);
        // while(head != null) {
        //     if(!map.containsKey(head)) {
        //         Node node = new Node(head.val);
        //         map.put(head, node);
        //     }

        // }

        Node cur = head;
        while(cur != null) {
            Node node = new Node(cur.val);
            oldToNew.put(cur, node);
            cur = cur.next;
        }

        Node curr = head;
        while(curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }
}
