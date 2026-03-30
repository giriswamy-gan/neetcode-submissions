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
        ListNode previous = dummy;
        ListNode cur = head;
        while(true) {
            ListNode kth = kth(cur, k);
            if(kth == null) {
                break;
            }
            ListNode next = kth.next;
            ListNode prev = previous;
            while(cur != next) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            ListNode tmp = previous.next;
            tmp.next = next;
            previous.next = prev;
            previous = tmp;
        }
        return dummy.next;
    }

    private ListNode kth(ListNode head, int k) {
        k--;
        while(head != null && k > 0) {
            head = head.next;
            k--;
        }
        return k > 0 ? null : head;
    }
}
