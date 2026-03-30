/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head.next == null) {
            return false;
        }
        else {
            if(head.next == head || head.next.next == head) return true;
        }
        ListNode r = head.next.next;
        ListNode t = head.next;
        while(r != null) {
            if(r == t) {
                return true;
            }
            r = r.next.next;
            t = t.next;
        }
        return false;
    }
}
