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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        List<ListNode> list = new ArrayList<>();
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        int l = 0, r = list.size() - 1;
        curr = head.next;
        while(l < r) {
            list.get(l).next = list.get(r);
            l++;
            if(l >= r) {
                break;
            }
            list.get(r).next = list.get(l);
            --r;
        }
        list.get(l).next = null;
    }
}
