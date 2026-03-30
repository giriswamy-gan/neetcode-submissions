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
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return String.join(",", res);
    }

    private void dfs(TreeNode root, List<String> res) {
        if(root == null) {
            res.add("N");
            return;
        }
        res.add(Integer.toString(root.val));
        dfs(root.left, res);
        dfs(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] pre = data.split(",");
        int[] i = {0};
        return dfs2(pre, i);
    }

    private TreeNode dfs2(String[] pre, int[] i) {
        if(pre[i[0]].equals("N")) {
            i[0]++;
            return null;
        }
        int val = Integer.parseInt(pre[i[0]]);
        TreeNode node = new TreeNode(val);
        i[0]++;
        node.left = dfs2(pre, i);
        node.right = dfs2(pre, i);
        return node;
    }
}
