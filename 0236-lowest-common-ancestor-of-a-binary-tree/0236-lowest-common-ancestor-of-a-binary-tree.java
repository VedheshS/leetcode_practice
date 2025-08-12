/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans=root;
        check(root,p,q);
        return ans;
    }
    boolean check(TreeNode cur,TreeNode p,TreeNode q){
        if(cur==null) return false;
        if(cur==p||cur==q){
            boolean n = check(cur.left,p,q);
            boolean t =check(cur.right,p,q);
            if(n||t) ans=cur;
            return true;
        }
        boolean n = check(cur.left,p,q);
        boolean t =check(cur.right,p,q);
        if(n&&t) ans=cur;
        return n||t;
    }
}