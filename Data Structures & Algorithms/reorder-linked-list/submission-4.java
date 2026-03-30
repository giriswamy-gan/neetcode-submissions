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
        if(head == null || head.next == null) return;
        //find mid point
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse second half
        ListNode second = slow.next;
        ListNode prevT = slow.next = null;
        while(second != null) {
            ListNode temp = second.next;
            second.next = prevT;
            prevT = second;
            second = temp;
        }

        // connect 2 lists
        while(prevT != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = prevT.next;
            head.next = prevT;
            prevT.next = temp1;
            head = temp1;
            prevT = temp2;
        }
    }
}

// [1 2 5 4 3]

// find the mid way point
// reverse the second half
// using the new mid pointer and the head pointer connect the 2 lists
