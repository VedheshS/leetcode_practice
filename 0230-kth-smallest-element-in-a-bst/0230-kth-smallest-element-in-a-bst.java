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
    static int n;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        n=1;
        check(root,k);
        return ans;
    }
    void check(TreeNode cur,int k){
        if(cur==null) return;
        check(cur.left,k);
        n++;
        if(n-1==k) ans=cur.val;
        check(cur.right,k);
    }
}