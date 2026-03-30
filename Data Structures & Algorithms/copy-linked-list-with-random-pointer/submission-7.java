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
        Node dummy = head;
        Map<Node, Node> map = new HashMap<>();
        while(head != null) {
            if(!map.containsKey(head)) {
                Node node = new Node(head.val);
                map.put(head, node);
            }
            Node cur = map.get(head);

            if(!map.containsKey(head.next)) {
                if(head.next != null) {
                    Node node = new Node(head.next.val);
                    map.put(head.next, node);
                } else {
                    map.put(head.next, null);
                }
            }
            Node next = map.get(head.next);
            cur.next = next;

            if(!map.containsKey(head.random)) {
                if(head.random != null) {
                    Node node = new Node(head.random.val);
                    map.put(head.random, node);
                } else {
                    map.put(head.random, null);
                }
            }
            Node random = map.get(head.random);
            cur.random = random;

            head = head.next;
        }

        return map.get(dummy);
    }
}
