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
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node curr = head;
        while(curr != null) {
            if(!map.containsKey(curr)) {
                map.put(curr, new Node(0));
            }
            map.get(curr).val = curr.val;

            if(!map.containsKey(curr.next)) {
                map.put(curr.next, new Node(0));
            }
            map.get(curr).next = map.get(curr.next);

            if(!map.containsKey(curr.random)) {
                map.put(curr.random, new Node(0));
            }
            map.get(curr).random = map.get(curr.random);

            curr = curr.next;
        }
        return map.get(head);
    }
}
