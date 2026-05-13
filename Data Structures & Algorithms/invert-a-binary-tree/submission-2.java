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
    public TreeNode invertTree(TreeNode root) {
        return invertTreeRec(root);
    }

    private TreeNode invertTreeRec(TreeNode root){
        if(root==null)
            return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        invertTreeRec(root.right);
        invertTreeRec(root.left);

        return root;
    }
}
