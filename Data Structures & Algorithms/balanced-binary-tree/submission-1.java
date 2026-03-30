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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        findHeight(root);
        // int left = findHeight(root.left);
        // int right = findHeight(root.right);
        // return left == right || left + 1 == right || right + 1 == left;
        return flag;
    }

    private int findHeight(TreeNode root) {
        if(root == null) return 0;
        int left = findHeight(root.left) + 1;
        int right = findHeight(root.right) + 1;
        if(!(left == right || left + 1 == right || right + 1 == left)) {
            flag = false;
        }
        return Math.max(left, right);
    }
}
