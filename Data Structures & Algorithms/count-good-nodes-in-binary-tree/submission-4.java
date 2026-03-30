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
    List<Integer> res = new ArrayList<>();
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        count(root, root.val);
        return res.size();
    }

    private void count(TreeNode root, int val) {
        if(root == null) return;
        if(root.val >= val) {
            val = root.val;
            res.add(root.val);
        }
        count(root.left, val);
        count(root.right, val);
    }
}
