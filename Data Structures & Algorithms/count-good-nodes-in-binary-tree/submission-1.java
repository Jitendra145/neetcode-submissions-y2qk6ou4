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
class Pair{
    TreeNode node;
    int val;
    public Pair(TreeNode node, int val){
        this.node = node;
        this.val = val;
    }
}
class Solution {
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,Integer.MIN_VALUE));
        int good = 0;
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            int largest = pair.val;
            if(node.val >= largest){
                good++;
            }
            largest = Math.max(largest,node.val);
            if(node.left!=null){
                stack.push(new Pair(node.left,largest));
            }
            if(node.right!=null){
                stack.push(new Pair(node.right,largest));
            }
        }
        return good;
    }
}
