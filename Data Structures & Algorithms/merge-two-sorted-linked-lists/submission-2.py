# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = node = ListNode()
        while list1 != None and list2 != None:
            if list1.val <= list2.val:
                node.next = list1
                node = node.next
                list1 = list1.next
            elif list2.val < list1.val:
                node.next = list2
                node = node.next
                list2 = list2.next
        
        if list1 != None:
            node.next = list1
        if list2 != None:
            node.next = list2
        
        return dummy.next