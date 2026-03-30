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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        Stack<ListNode> res = new Stack<>();
        res.add(lists[0]);
        res.add(lists[1]);
        int i = 2;
        while(true) {
            ListNode list1 = res.pop();
            ListNode list2 = res.pop();
            res.add(merge2Lists(list1, list2));
            if(i == lists.length) {
                break;
            }
            res.add(lists[i]);
            ++i;
        }
        return res.pop();
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(0);
        ListNode res = node;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        while(list1 != null) {
            node.next = list1;
            node = node.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            node.next = list2;
            node = node.next;
            list2 = list2.next;
        }
        return res.next;
    }
}
