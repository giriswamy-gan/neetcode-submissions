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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean helper(TreeNode root, int curMax, int curMin) {
        if(root == null) return true;
        if(root.val > curMin && root.val < curMax) {
            return helper(root.left, root.val, curMin) && 
            helper(root.right, curMax, root.val);
        } else {
            return false;
        }
    }
}
