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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1,root2);
    }
    boolean check(TreeNode cur,TreeNode cur1){
        if(cur==null&&cur1==null) return true;
        else if(cur==null||cur1==null||cur.val!=cur1.val) return false;
        return (check(cur.left,cur1.left)&&check(cur.right,cur1.right)) || (check(cur.left,cur1.right) && check(cur.right,cur1.left));
        
    }
}