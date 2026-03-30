# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = [0]
        def countNodes(root, maxVal, count):
            if root == None:
                return
            if root.val >= maxVal:
                count[0] += 1
            maxVal = max(maxVal, root.val)
            countNodes(root.left, maxVal, count)
            countNodes(root.right, maxVal, count)

        countNodes(root, root.val, count)
        return count[0]
