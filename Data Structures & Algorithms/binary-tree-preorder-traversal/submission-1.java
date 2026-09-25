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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        preorderRec(root,res);
        return res;
    }

    private void preorderRec(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        
        res.add(root.val);
        preorderRec(root.left, res);
        preorderRec(root.right, res);
    }
}