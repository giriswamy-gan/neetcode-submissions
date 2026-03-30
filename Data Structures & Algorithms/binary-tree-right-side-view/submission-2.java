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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        res.add(root.val);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i<n; ++i) {
                TreeNode curr = q.remove();
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(q.peekLast() != null) {
                res.add(q.peekLast().val);
            }
        }
        return res;
    }
}
