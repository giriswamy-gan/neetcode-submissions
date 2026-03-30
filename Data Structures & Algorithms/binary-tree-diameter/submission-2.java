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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);
        int diameter = left + right;
        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(sub, diameter);
    }

    private int findHeight(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
