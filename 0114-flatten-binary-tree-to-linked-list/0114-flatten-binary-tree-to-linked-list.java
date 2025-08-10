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
    public void flatten(TreeNode root) {
        if(root==null||(root.left==null && root.right==null)) return;
        convert(root);
    }
    TreeNode convert(TreeNode cur){
        if(cur==null) return null;
        if(cur.left==null && cur.right==null) return cur;
        TreeNode lnode=convert(cur.left);
        TreeNode rnode=convert(cur.right);

        if(lnode!=null){
            lnode.right=cur.right;
            cur.right=cur.left;
            cur.left=null;
        }

        return rnode!=null ? rnode:lnode;
    } 
}