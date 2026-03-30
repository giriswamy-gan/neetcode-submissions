/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null && subRoot != null || root != null && subRoot == null) return false;
        if(root.val == subRoot.val) {
            if(subtreeHelper(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean subtreeHelper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != null && q != null && p.val == q.val) {
            return subtreeHelper(p.left, q.left) && subtreeHelper(p.right, q.right);
        } else {
            return false;
        }
    }
}
