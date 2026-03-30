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
    public boolean isBalanced(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        if(res[0] == -1) {
            return false;
        }
        return true;
    }

    public int dfs(TreeNode root, int[] res) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        if(Math.abs(left - right) > 1) {
            res[0] = -1;
        }
        return 1 + Math.max(left, right);
    }
}
