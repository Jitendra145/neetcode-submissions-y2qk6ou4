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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        levelOrder(root,res);
        return res;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> res){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = q.size();i>0;i--){
                TreeNode node = q.poll();
                if(node!=null){
                    q.offer(node.left);
                    q.offer(node.right);
                    list.add(node.val);
                }
            }
            if(!list.isEmpty())
             res.add(list);
        }
    }
}
