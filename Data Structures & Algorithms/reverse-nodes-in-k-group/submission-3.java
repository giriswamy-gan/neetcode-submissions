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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        
        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;
            ListNode groupNext = kth.next;

            ListNode prev = kth.next;
            ListNode cur = groupPrev.next;
            while(cur != groupNext) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode head, int k) {
        while(head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }
}
