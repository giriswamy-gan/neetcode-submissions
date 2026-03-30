# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = [0]
        def countNodes(root, val, count):
            if root == None:
                return
            if root.val >= val:
                count[0] += 1
            countNodes(root.left, root.val if root.val > val else val, count)
            countNodes(root.right, root.val if root.val > val else val, count)

        countNodes(root, root.val, count)
        return count[0]
