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
        if(head.next == null) return;

        // logic for finding mid point
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // logic for reversing second half
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while(second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        ListNode tail = prev;

        while(tail != null) {
            ListNode tempHead = head.next;
            ListNode tempTail = tail.next;
            head.next = tail;
            tail.next = tempHead;
            head = tempHead;
            tail = tempTail;
        }
    }
}

// use fast and slow pointers to find the mid point of the array
// check if fast pointer == null or fast pointer.next == null
// reverse the second half of the list
// use 2 temporary nodes, one in beginning and one in end to keep track of nodes after reordering
// when the 2 temporary nodes meet each other then we can break the loop.
// make the last node point to null 
