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

        while(lists.length > 1) {
            List<ListNode> res = new ArrayList<>();
            for(int i=0; i<lists.length; i+=2) {
                ListNode list1 = lists[i];
                ListNode list2 = (i + 1) < lists.length ? lists[i+1] : null;
                res.add(merge2Lists(list1, list2));
            }
            lists = res.toArray(new ListNode[0]);
        }
        return lists[0];
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

// [0, 1, 2, 3]
