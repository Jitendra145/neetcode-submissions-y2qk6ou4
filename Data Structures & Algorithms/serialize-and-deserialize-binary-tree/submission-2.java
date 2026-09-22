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
//O(n),O(n)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrderSerialize(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = {0};
        return deserialize(nodes,index);
    }

    private void preOrderSerialize(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        preOrderSerialize(root.left,sb);
        preOrderSerialize(root.right,sb);
    }

    private TreeNode deserialize(String[] nodes,int[] index){
        if(index[0] >=nodes.length || nodes[index[0]].equals("null")){
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        node.left = deserialize(nodes,index);
        node.right = deserialize(nodes,index);
        return node;
    }
}
