# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        arr = []
        for i in range(len(lists)):
            while lists[i]:
                arr.append(lists[i].val)
                lists[i] = lists[i].next
        
        arr.sort()
        res = ListNode(0)
        dummy = res
        for node in arr:
            res.next = ListNode(node)
            res = res.next
        
        return dummy.next
