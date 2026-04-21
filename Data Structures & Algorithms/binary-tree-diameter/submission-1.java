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
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        bTreeRecur(root);
        return maxDiameter;
    }

    private int bTreeRecur(TreeNode root){
        if(root==null)
            return 0;
        int left = bTreeRecur(root.left);
        int right = bTreeRecur(root.right);

        if(left+right > maxDiameter){
            maxDiameter = left+right;
        }

        return 1+Math.max(left,right);
    }
}
