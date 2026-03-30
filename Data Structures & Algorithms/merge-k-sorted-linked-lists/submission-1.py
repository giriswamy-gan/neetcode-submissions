# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: ListNode, list2: ListNode) -> ListNode:
        node = ListNode(0)
        head = node
        while list1 and list2:
            if list1.val <= list2.val:
                node.next = list1
                list1 = list1.next
            else:
                node.next = list2
                list2 = list2.next
            node = node.next
        
        if list1:
            node.next = list1
        if list2:
            node.next = list2
        return head.next


    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0 or len(lists) == 1:
            return None
        for i in range(1, len(lists)):
            lists[i] = self.mergeTwoLists(lists[i-1], lists[i])
        
        return lists[len(lists) - 1]
