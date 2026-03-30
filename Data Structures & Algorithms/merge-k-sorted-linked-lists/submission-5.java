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
        List<ListNode> arraylist = Arrays.asList(lists);
        
        while(arraylist.size() > 1) {
            List<ListNode> temp = new ArrayList<>();
            for(int i=0; i<arraylist.size(); i+=2) {
                System.out.println(i);
                ListNode l1 = arraylist.get(i);
                ListNode l2 = i + 1 < arraylist.size() ? arraylist.get(i+1) : null;
                temp.add(merge2Lists(l1, l2));
            }
            arraylist = temp;
        }
        return arraylist.get(0);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if(l1 != null) dummy.next = l1;
        if(l2 != null) dummy.next = l2;
        return cur.next;
    }
}
