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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder cur = new StringBuilder();
        preorder(root, cur);
        cur.deleteCharAt(cur.length() - 1);
        return cur.toString();
    }

    private void preorder(TreeNode root, StringBuilder cur) {
        if(root == null) {
            cur.append("N").append(",");
            return;
        }
        cur.append(root.val).append(",");
        preorder(root.left, cur);
        preorder(root.right, cur);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] idx = {0};
        return deHelper(nodes, idx);
    }
    
    private TreeNode deHelper(String[] nodes, int[] idx) {
        if(nodes[idx[0]].equals("N")) {
            idx[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx[0]]));
        idx[0]++;
        node.left = deHelper(nodes, idx);
        node.right = deHelper(nodes, idx);
        return node;
    }
}

// 1,2,N,N,3,4,N,N,5,N,N
