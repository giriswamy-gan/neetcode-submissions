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
    int res;
    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftTree = Math.max(0, dfs(root.left));
        int rightTree = Math.max(0, dfs(root.right));
        res = Math.max(res, leftTree + rightTree + root.val);
        return root.val + Math.max(leftTree, rightTree);
    }
}