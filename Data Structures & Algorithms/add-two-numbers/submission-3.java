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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode output = dummy;
        while(l1 != null && l2 != null) {
            int res = l1.val + l2.val;
            if(carry > 0) {
                res += carry;
            }
            if(res >= 10) {
                res = res - 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            ListNode temp = new ListNode(res);
            System.out.println(temp.val);
            output.next = temp;
            output = output.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null) {
            int res = l1.val;
            if(carry > 0) {
                res += carry;
            }
            if(res >= 10) {
                res = res - 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            ListNode temp = new ListNode(res);
            output.next = temp;
            output = output.next;
            l1 = l1.next;
        }
        while(l2!=null) {
            int res = l2.val;
            if(carry > 0) {
                res += carry;
            }
            if(res >= 10) {
                res = res - 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            ListNode temp = new ListNode(res);
            output.next = temp;
            output = output.next;
            l2 = l2.next;
        }
        if(carry > 0) {
            ListNode temp = new ListNode(carry);
            output.next = temp;
            output = output.next;
        }
        return dummy.next;
    }
}
