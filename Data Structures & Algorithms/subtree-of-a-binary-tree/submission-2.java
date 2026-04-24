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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return hasSubTree(root,subRoot);
    }

    private boolean hasSubTree(TreeNode root, TreeNode subRoot){
        if(root==null){
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }

        return hasSubTree(root.left,subRoot) || hasSubTree(root.right,subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null && subRoot!=null){
            return false;
        }
        if(root!=null && subRoot==null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }

        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }
}
