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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return check(root,targetSum,0);
    }
    boolean check(TreeNode cur,int tar,int sum){
        sum+=cur.val;
        if(cur.left==null&&cur.right==null){
            return tar==sum;
        }
        if(cur.left==null||cur.right==null){
            if(cur.left==null) return check(cur.right,tar,sum);
            else return check(cur.left,tar,sum);
        }
        boolean left=check(cur.left,tar,sum);
        boolean right=check(cur.right,tar,sum);
        return left||right;
    }
}