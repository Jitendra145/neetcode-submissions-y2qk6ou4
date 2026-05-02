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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int[] preIndex = {0};
        return buildTree(preorder,map,preIndex,0,preorder.length-1);
    }
    
    private TreeNode buildTree(int[] preorder,Map<Integer,Integer> map, int[] preIndex,int left,int right){
        if(left > right)
            return null;
        
        Integer val = preorder[preIndex[0]];
        preIndex[0]++;
        TreeNode node = new TreeNode(val);
        int index = map.get(val);

        node.left = buildTree(preorder,map,preIndex,left,index-1);
        node.right = buildTree(preorder,map,preIndex,index+1,right);

        return node;
    }
}
