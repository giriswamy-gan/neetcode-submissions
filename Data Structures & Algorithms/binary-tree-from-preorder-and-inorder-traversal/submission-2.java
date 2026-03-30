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
    Map<Integer, Integer> indexes = new HashMap<>();
    int pre_idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; ++i) {
            indexes.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int l, int r) {
        if(l > r) return null;
        int rootVal = preorder[pre_idx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = indexes.get(rootVal);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        return root;
    }
}

// get the index of root node in inorder with the help of preorder
// left half will be left subtree, right half right subtree
// next element of preorder will be left subtree, find that in inorder and the same process will apply


// [4, 2, 1, 3] - inorder
// [1, 2, 4, 3] - preorder