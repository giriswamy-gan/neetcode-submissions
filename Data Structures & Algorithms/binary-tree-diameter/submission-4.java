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
    int[] res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = new int[1];
        findHeight(root);
        return res[0];
    }

    private int findHeight(TreeNode root) {
        if(root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }
}
